package net.gt.boot.autoconfig;

import net.gt.core.config.FileDatabaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 文件数据库自动配置
 *
 * @author gt-it
 * @since 2023/1/17
 */

@EnableConfigurationProperties({FileDatabaseProperties.class})
public class FileDatabaseAutoConfiguration {

//    @Primary
//    @Bean
//    public <T> BaseFileMapper<T> getBaseMapperFileMapper() {
//        return new BaseFileMapperImpl<>();
//    }

}
