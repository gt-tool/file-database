package net.gt.core.bean;

import net.gt.core.annotations.FileMapperScans;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

/**
 * mapper扫描仪注册
 *
 * @author gt-it
 * @since 2023/1/18
 */
public class BeanRegistrar implements BeanDefinitionRegistryPostProcessor, ResourceLoaderAware, ApplicationContextAware {


    /**
     * 设置资源加载器
     *
     * @param resourceLoader 资源加载器
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
    }

    private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
        return importingClassMetadata.getClassName() + "#" + BeanRegistrar.class.getSimpleName() + "#" + index;
    }

    private static String getDefaultBasePackage(AnnotationMetadata importingClassMetadata) {
        return ClassUtils.getPackageName(importingClassMetadata.getClassName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

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
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            AnnotationAttributes mapperScansAttrs = AnnotationAttributes
                    .fromMap(importingClassMetadata.getAnnotationAttributes(FileMapperScans.class.getName()));
        }
    }
}

