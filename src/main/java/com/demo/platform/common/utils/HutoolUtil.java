package com.demo.platform.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HutoolUtil {

    private static Logger logger = LoggerFactory.getLogger(HutoolUtil.class);

    public static void main(String[] args) {
        String str = "123456";

        // 32位MD5加密
        logger.info(SecureUtil.md5(str));

        logger.info("***********************************************");

        //AES加密(对称加密)
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        AES aes = SecureUtil.aes(key);
        String encryptStr = aes.encryptHex(str);
        String decryptStr = aes.decryptStr(encryptStr, CharsetUtil.CHARSET_UTF_8);
        logger.info(encryptStr);
        logger.info(decryptStr);

        logger.info("***********************************************");

        // 类型转换
        String[] a1 = {"1", "2", "3"};
        String a2 = "1,2,3";
        // 数组转list
        List<String> list = (List<String>)Convert.toList(a1);
        // 字符串转list
        List<String> list1 = (List<String>)Convert.toList(a2);
        // 字符串转Integer
        Integer j = Convert.toInt("a011");
        logger.info(Convert.toStr(j));

        String dateStr = DateUtil.format(new Date(), "yyyy-MM-dd HH");
        logger.info(dateStr);

        String beginOfDay = DateUtil.beginOfDay(new Date()).toString("yyyy-MM-dd HH:mm:ss");
        String endOfDay = DateUtil.endOfDay(new Date()).toString("yyyy-MM-dd HH:mm:ss");
        logger.info("本日开始时间：" + beginOfDay);
        logger.info("本日开始时间：" + endOfDay);

        String beginOfMonth = DateUtil.beginOfMonth(new Date()).toString("yyyy-MM-dd HH:mm:ss");
        String endOfMonth = DateUtil.endOfMonth(new Date()).toString("yyyy-MM-dd HH:mm:ss");
        logger.info("本月开始日期：" + beginOfMonth);
        logger.info("本月结束日期：" + endOfMonth);

        String  beginOfWeek = DateUtil.beginOfWeek(new Date()).toString("yyyy-MM-dd HH:mm:ss");
        String  endOfWeek = DateUtil.endOfWeek(new Date()).toString("yyyy-MM-dd HH:mm:ss");
        logger.info("本周开始日期：" + beginOfWeek);
        logger.info("本周结束日期：" + endOfWeek);

        String date01 = DateUtil.offsetDay(new Date(), 2).toString("yyyy-MM-dd HH:mm:ss");
        logger.info("当前日期加2天：" + date01);




        int i = 0;






    }

    public static String mail() {
        MailAccount account = new MailAccount();
        account.setHost("smtp.126.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("zhangweiweikol@126.com");
        account.setUser("zhangweiweikol@126.com");
        account.setPass("kol262323");
        String result = MailUtil.send(account, CollUtil.newArrayList("15542449355@163.com"),
                "测试", "邮件来自Hutool测试", false);
        return result;
    }


}
