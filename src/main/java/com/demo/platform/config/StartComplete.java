package com.demo.platform.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class StartComplete implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(StartComplete.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("=============  项目启动完成!  =============");
    }

}
