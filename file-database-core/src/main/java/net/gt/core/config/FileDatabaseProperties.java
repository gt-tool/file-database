package net.gt.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 基本属性
 *
 * @author gt-it
 * @since 2023/1/17
 */

@Setter
@Getter
@ConfigurationProperties("file-database")
public class FileDatabaseProperties {

    /**
     * 文件数据库路径
     */
    private String dataPath;


}
