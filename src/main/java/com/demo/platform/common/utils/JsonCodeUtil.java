package com.demo.platform.common.utils;

import cn.miludeer.jsoncode.JsonCode;

public class JsonCodeUtil {

    public static void main(String[] args) {
        String jsonStr = "{\"accountId\": \"1\",  \"accountNo\": \"zhangsan\",  \"password\": \"111\",  \"role\": \"admin\"}";
        String accountId = JsonCode.getValue(jsonStr, "$.accountId");
        System.out.println(accountId);
    }

}
