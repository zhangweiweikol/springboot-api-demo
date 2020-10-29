package com.demo.platform.common.global;

import com.demo.platform.common.enums.ResultEnum;
import lombok.Data;

/**
 * 响应数据
 */
@Data
public class ResponeData<T> {

    private int code;

    private String msg;

    private T data;

    public ResponeData(T data) {
        this(ResultEnum.SUCCESS,data);
    }

    public ResponeData(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }
}
