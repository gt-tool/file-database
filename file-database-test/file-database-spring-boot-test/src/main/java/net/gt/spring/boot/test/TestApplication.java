package net.gt.spring.boot.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试应用程序
 *
 * @author gt-it
 * @version 0.0.1
 * @since 2023/01/17
 */

@SpringBootApplication(scanBasePackages = {"net.gt.spring.boot.test.filedao"})
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
