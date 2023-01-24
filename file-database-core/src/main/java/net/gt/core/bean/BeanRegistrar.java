package net.gt.core.bean;

import net.gt.core.annotations.FileMapperScan;
import net.gt.core.annotations.FileMapperScans;
import net.gt.core.mapper.FileMapperScannerConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

/**
 * mapper扫描仪注册
 *
 * @author gt-it
 * @since 2023/1/18
 */
public class BeanRegistrar implements ApplicationContextAware, ImportBeanDefinitionRegistrar, ResourceLoaderAware {


    private ApplicationContext applicationContext;

    private ResourceLoader resourceLoader;

    private ResourcePatternResolver resourcePatternResolver;

    private MetadataReaderFactory metadataReaderFactory;

    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    /**
     * 设置资源加载器
     *
     * @param resourceLoader 资源加载器
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        this.resourceLoader = resourceLoader;
        this.metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
    }

    private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
        return importingClassMetadata.getClassName() + "#" + BeanRegistrar.class.getSimpleName() + "#" + index;
    }

    private static String getDefaultBasePackage(AnnotationMetadata importingClassMetadata) {
        return ClassUtils.getPackageName(importingClassMetadata.getClassName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
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
     * 根据包路径获取包及子包下的所有类
     *
     * @param basePackage basePackage
     * @return Set<Class < ?>> Set<Class<?>>
     */
    private Set<Class<?>> scannerPackages(String basePackage) {
        Set<Class<?>> set = new LinkedHashSet<>();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                resolveBasePackage(basePackage) + '/' + DEFAULT_RESOURCE_PATTERN;
        try {
            Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);
            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
                    String className = metadataReader.getClassMetadata().getClassName();
                    Class<?> clazz;
                    try {
                        clazz = Class.forName(className);
                        set.add(clazz);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

    protected String resolveBasePackage(String basePackage) {
        return ClassUtils.convertClassNameToResourcePath(this.getEnvironment().resolveRequiredPlaceholders(basePackage));
    }

    private Environment getEnvironment() {
//        return null;
        return applicationContext.getEnvironment();
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

