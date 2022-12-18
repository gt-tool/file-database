package net.gt.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件数据库表名
 *
 * @author gt-it
 * @since 2022/12/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FileTableName {

    /**
     * 表名
     */
    String value() default "";

}
