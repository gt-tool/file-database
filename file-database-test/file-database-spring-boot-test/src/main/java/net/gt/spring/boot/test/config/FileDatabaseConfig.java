package net.gt.spring.boot.test.config;

import net.gt.core.mapper.FileMapper;
import net.gt.core.mapper.impl.BaseFileMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述
 *
 * @author gt-it
 * @since 2023/1/18
 */

@Configuration
public class FileDatabaseConfig<T> {

    @Bean
    public FileMapper<T> getFileMapper() {
        return new BaseFileMapperImpl<>();
    }

}