package net.gt.core.annotations.mapper;

import org.springframework.core.annotation.AliasFor;

/**
 * 文件数据库映射器扫描
 *
 * @author gt-it
 * @version 0.0.1
 * @since 2023/01/17
 */
public @interface FileDatabaseMapperScan {

    /**
     * value
     *
     * @return {@link String[]}
     */
    @AliasFor("basePackages")
    String[] value() default {};

    /**
     * 基本包
     *
     * @return {@link String[]}
     */
    @AliasFor("value")
    String[] basePackages() default {};

}
