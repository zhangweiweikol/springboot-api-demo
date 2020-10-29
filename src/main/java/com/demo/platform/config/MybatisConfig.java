package com.demo.platform.config;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({"com.demo.modules.bussiness.dao", "com.demo.modules.sys.dao"})
@Configuration
public class MybatisConfig{

    /**
     *  fix : No MyBatis mapper was found in '[xx.mapper]' package. Please check your configuration
     */
    @Mapper
    public interface NoWarnMapper {
    }
}
