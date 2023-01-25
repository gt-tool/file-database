package net.gt.core.bean;

import net.gt.core.annotations.FileMapperScan;
import net.gt.core.annotations.FileMapperScans;
import net.gt.core.mapper.FileMapperScannerConfigurer;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * mapper扫描仪注册
 *
 * @author gt-it
 * @since 2023/1/18
 */
public class BeanRegistrar implements ImportBeanDefinitionRegistrar {


    private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
        return importingClassMetadata.getClassName() + "#" + BeanRegistrar.class.getSimpleName() + "#" + index;
    }

    private static String getDefaultBasePackage(AnnotationMetadata importingClassMetadata) {
        return ClassUtils.getPackageName(importingClassMetadata.getClassName());
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes mapperScanAttrs = AnnotationAttributes
                .fromMap(importingClassMetadata.getAnnotationAttributes(FileMapperScan.class.getName()));
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(FileMapperScannerConfigurer.class);
        if (mapperScanAttrs != null) {
            /*List<String> basePackageList = new ArrayList<>();
            basePackageList.addAll(Arrays.stream(mapperScanAttrs.getStringArray("basePackages"))
                    .collect(Collectors.toList()));

            if (CollectionUtils.isEmpty(basePackageList)) {
                basePackageList.add(getDefaultBasePackage(importingClassMetadata));
            }

            StringUtils.collectionToCommaDelimitedString(basePackageList);

            for (String basePackage : basePackageList) {
                Set<Class<?>> classes = scannerPackages(basePackage);
                for (Class<?> aClass : classes) {
                    BeanDefinition beanDefinition = new RootBeanDefinition(aClass);
                    registry.registerBeanDefinition("company", beanDefinition);
                }
            }*/


            // 拆分！！！！！！
            Class<? extends Annotation> annotationClass = mapperScanAttrs.getClass("annotationClass");
            if (!Annotation.class.equals(annotationClass)) {
                builder.addPropertyValue("annotationClass", annotationClass);
            }

            List<String> basePackages = new ArrayList<>();

            basePackages.addAll(Arrays.stream(mapperScanAttrs.getStringArray("basePackages"))
                    .filter(StringUtils::hasText)
                    .collect(Collectors.toList()));

            basePackages.addAll(Arrays.stream(mapperScanAttrs.getClassArray("basePackageClasses"))
                    .map(ClassUtils::getPackageName)
                    .collect(Collectors.toList()));

            if (basePackages.isEmpty()) {
                basePackages.add(getDefaultBasePackage(importingClassMetadata));
            }

            builder.addPropertyValue("basePackage", StringUtils.collectionToCommaDelimitedString(basePackages));

            // for spring-native
            builder.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            registry.registerBeanDefinition(generateBaseBeanName(importingClassMetadata, 0), builder.getBeanDefinition());

        }
    }

    /**
     * A {@link BeanRegistrar} for {@link FileMapperScans}.
     *
     * @since 2.0.0
     */
    public static class RepeatingRegistrar extends BeanRegistrar {
        /**
         * {@inheritDoc}
         */
        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            AnnotationAttributes mapperScansAttrs = AnnotationAttributes
                    .fromMap(importingClassMetadata.getAnnotationAttributes(FileMapperScans.class.getName()));
        }
    }
}

