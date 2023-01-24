package net.gt.core.annotations;

import net.gt.core.bean.BeanRegistrar;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;


/**
 * 映射器扫描
 *
 * @author jason
 * @date 2023/01/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(BeanRegistrar.class)
@Repeatable(FileMapperScans.class)
public @interface FileMapperScan {

    @AliasFor("basePackages")
    String[] value() default {};

    @AliasFor("value")
    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};

    Class<? extends Annotation> annotationClass() default Annotation.class;

    String defaultScope() default AbstractBeanDefinition.SCOPE_DEFAULT;

}
