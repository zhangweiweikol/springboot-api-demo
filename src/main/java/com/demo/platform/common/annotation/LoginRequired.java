package com.demo.platform.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要登录验证的Controller的方法上使用此注解
 * @Target 注解的作用范围 方法之上
 * @Retention 注解的生存周期  运行级别，注解存在于源码、字节码、java虚拟机中，主要用于运行时，可以使用反射获取相关的信息
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
}
