package com.demo.modules.sys.entity;

import com.demo.platform.common.global.BaseFiled;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * 系统账号实体类
 * @author shiling
 * @version 2020-04-28
 */
@Data
public class AccountField extends BaseFiled {

    //账号ID 计划使用UUID，方便跟各用户之间进行一对一关联
    private String accountId;
    //登录账号
    @NotEmpty(message = "登录账号不能为空")
    private String accountNo;
    //登录密码
    @Size(min = 5, max = 11, message = "密码长度必须介于5-11之间")
    private String password;
    //用户身份
    private String role;


}
