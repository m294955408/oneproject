package com.shuma.oneproject.userinterface.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Demo项目启动类
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@SpringBootApplication
@ComponentScan(value = {
        "com.shuma.oneproject"
})
public class DemoApplication {

    public static void main (String[] args) {
        new SpringApplicationBuilder(DemoApplication.class)
                .run(args);
    }

}
