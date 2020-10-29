package com.demo.platform.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常类
 * @author shiling
 * @version 2020-04-28
 */
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private int code;
    private String msg;

}
