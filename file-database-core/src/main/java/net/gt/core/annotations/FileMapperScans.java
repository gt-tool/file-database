package net.gt.core.annotations;

import net.gt.core.bean.BeanRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 声明文件数据库Mapper
 *
 * @author gt-it
 * @since 2022/12/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(BeanRegistrar.RepeatingRegistrar.class)
public @interface FileMapperScans {

    FileMapperScan[] value();

}
