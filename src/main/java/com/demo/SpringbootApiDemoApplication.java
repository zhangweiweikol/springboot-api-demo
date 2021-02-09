package com.demo;

import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ForestScan(basePackages = "com.demo.modules.api.service")
public class SpringbootApiDemoApplication {

    public static void main(String[] args) {
        String addClassPath = "spring.config.additional-location:";
        addClassPath += "classpath:/";
        addClassPath += ",classpath:/config/";
        addClassPath += ",classpath:/config/*/";
        new SpringApplicationBuilder(SpringbootApiDemoApplication.class).properties("spring.config.name:application",
                addClassPath).build().run(args);
    }

}
