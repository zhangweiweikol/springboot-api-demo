package com.demo.platform.common.exception;

import com.demo.platform.common.enums.ResultEnum;
import com.demo.platform.common.global.ResponeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类 加上@ControllerAdvice注解或者@RestControllerAdvice,
 * 加@RestControllerAdvice只能全局处理RestFul接口异常
 * @author shiling
 * @version 2020-04-28
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    /**
     * 表单验证异常处理（json字符串方式走的是这个异常处理）
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponeData<String> BindExceptionHandler(BindException e) {
        ObjectError objectError = e.getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        logger.error("表单数据校验异常",e);
        return new ResponeData<>(ResultEnum.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    /**
     * 表单验证异常（json对象提交方式走的是这个异常处理）
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponeData<String> BindExceptionHandler(MethodArgumentNotValidException e) {
        logger.error("表单数据校验异常",e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        // 注意哦，这里传递的响应码枚举
        return new ResponeData<>(ResultEnum.VALIDATE_FAILED, message);
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponeData<String> CustomExceptionHandler(CustomException e) {
        logger.error("自定义异常",e);
        // 注意哦，这里传递的响应码枚举
        if (4040 == e.getCode()){
            return new ResponeData<>(ResultEnum.LOGIN_FAILED, e.getMsg());
        }else {
            return new ResponeData<>(ResultEnum.FAILED, e.getMsg());
        }
    }

    /**
     * Exception异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponeData<String> ExceptionHandler(Exception e) {
        String data = "服务异常";
        //记录日志信息
        logger.error("服务异常",e);
        // 注意哦，这里传递的响应码枚举
        if (e instanceof HttpRequestMethodNotSupportedException){
            data = "请求方式错误，请注意区分GET请求，POST请求";
        }
        return new ResponeData<>(ResultEnum.FAILED, data);
    }


}
