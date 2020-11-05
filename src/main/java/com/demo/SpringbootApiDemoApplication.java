package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootApiDemoApplication {

    public static void main(String[] args) {
        String addClassPath = "spring.config.additional-location:";
        addClassPath += "classpath:/";
        addClassPath += ",classpath:/config/";
        addClassPath += ",classpath:/config/*/";
        new SpringApplicationBuilder(SpringbootApiDemoApplication.class).properties("spring.config.name:application",
                addClassPath).build().run(args);

        // SpringApplication.run(SpringbootApiDemoApplication.class, args);
    }

}
