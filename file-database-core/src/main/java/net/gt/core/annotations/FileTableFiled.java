package net.gt.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件数据库字段名
 *
 * @author gt-it
 * @since 2022/12/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FileTableFiled {

    /**
     * 字段名
     * <p>
     * default: snake case
     * </p>
     */
    String value();

}
