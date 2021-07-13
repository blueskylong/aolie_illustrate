package com.ranranx.aolie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author xxl
 * @version V0.0.1
 * @date 2021/3/4 0004 12:18
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AolieApplication {

    public static void main(String[] args) {
        SpringApplication.run(AolieApplication.class, args);
    }

}
