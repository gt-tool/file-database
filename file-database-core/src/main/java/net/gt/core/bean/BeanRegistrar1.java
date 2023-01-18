package net.gt.core.bean;//package net.gt.core.bean;
//
//import net.gt.core.annotations.FileMapperScan;
//import net.gt.core.annotations.FileMapperScans;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.support.AbstractBeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.context.ResourceLoaderAware;
//import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
//import org.springframework.core.annotation.AnnotationAttributes;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.core.type.AnnotationMetadata;
//import org.springframework.util.ClassUtils;
//import org.springframework.util.StringUtils;
//
//import java.lang.annotation.Annotation;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * mapper扫描仪注册
// *
// * @author gt-it
// * @since 2023/1/18
// */
//public class BeanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
//
//
//    /**
//     * 设置资源加载器
//     *
//     * @param resourceLoader 资源加载器
//     */
//    @Override
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        AnnotationAttributes mapperScanAttrs = AnnotationAttributes
//                .fromMap(importingClassMetadata.getAnnotationAttributes(FileMapperScan.class.getName()));
//        if (mapperScanAttrs != null) {
//            registerBeanDefinitions(importingClassMetadata, mapperScanAttrs, registry,
//                    generateBaseBeanName(importingClassMetadata, 0));
//        }
//    }
//
//    void registerBeanDefinitions(AnnotationMetadata annoMeta, AnnotationAttributes annoAttrs,
//                                 BeanDefinitionRegistry registry, String beanName) {
//
//        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
//        builder.addPropertyValue("processPropertyPlaceHolders", true);
//
//        Class<? extends Annotation> annotationClass = annoAttrs.getClass("annotationClass");
//        if (!Annotation.class.equals(annotationClass)) {
//            builder.addPropertyValue("annotationClass", annotationClass);
//        }
//
//        List<String> basePackages = new ArrayList<>();
//
//        basePackages.addAll(Arrays.stream(annoAttrs.getStringArray("basePackages")).filter(StringUtils::hasText)
//                .collect(Collectors.toList()));
//
////        basePackages.addAll(Arrays.stream(annoAttrs.getClassArray("basePackageClasses")).map(ClassUtils::getPackageName)
////                .collect(Collectors.toList()));
//
//        if (basePackages.isEmpty()) {
//            basePackages.add(getDefaultBasePackage(annoMeta));
//        }
//
//        String defaultScope = annoAttrs.getString("defaultScope");
//        if (!AbstractBeanDefinition.SCOPE_DEFAULT.equals(defaultScope)) {
//            builder.addPropertyValue("defaultScope", defaultScope);
//        }
//
//        builder.addPropertyValue("basePackage", StringUtils.collectionToCommaDelimitedString(basePackages));
//
//        // for spring-native
//        builder.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
//
//        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
//
//    }
//
//    private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
//        return importingClassMetadata.getClassName() + "#" + BeanRegistrar.class.getSimpleName() + "#" + index;
//    }
//
//    private static String getDefaultBasePackage(AnnotationMetadata importingClassMetadata) {
//        return ClassUtils.getPackageName(importingClassMetadata.getClassName());
//    }
//
//    /**
//     * A {@link BeanRegistrar} for {@link FileMapperScans}.
//     *
//     * @since 2.0.0
//     */
//    public static class RepeatingRegistrar extends BeanRegistrar {
//        /**
//         * {@inheritDoc}
//         */
//        @Override
//        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//            AnnotationAttributes mapperScansAttrs = AnnotationAttributes
//                    .fromMap(importingClassMetadata.getAnnotationAttributes(FileMapperScans.class.getName()));
//            if (mapperScansAttrs != null) {
//                AnnotationAttributes[] annotations = mapperScansAttrs.getAnnotationArray("value");
//                for (int i = 0; i < annotations.length; i++) {
//                    registerBeanDefinitions(importingClassMetadata, annotations[i], registry,
//                            generateBaseBeanName(importingClassMetadata, i));
//                }
//            }
//        }
//    }
//
//}
