package com.demo.platform.common.aspect;

import com.demo.platform.common.annotation.SysLog;
import com.demo.platform.common.utils.JwtUtil;
import com.demo.platform.common.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SysLogAspect {

    Logger logger = LoggerFactory.getLogger(SysLogAspect.class);


    /**
     * 切入点  这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.demo.platform.common.annotation.SysLog)")
    public void logPointCut(){
    }

    /**
     * 切入点正常退出执行
     * @param joinPoint
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doAfter(JoinPoint joinPoint)
    {
        logger.info("开始aop处理：");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = method.getAnnotation(SysLog.class);
        logger.info(sysLog.title());
        String token = ServletUtils.getRequest().getHeader("token");
        if (StringUtils.isEmpty(token)) {
            logger.info("操作用户ID：匿名用户");
        } else {
            logger.info("操作用户ID："+ JwtUtil.parseToken(token).getId());
            //在此处获取一系列信息 存入数据库日志表....
        }
    }


}
