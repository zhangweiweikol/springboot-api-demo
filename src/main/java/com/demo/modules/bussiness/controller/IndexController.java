package com.demo.modules.bussiness.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.demo.modules.bussiness.entity.User;
import com.demo.platform.common.global.ResponeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("index")
public class IndexController {

    @GetMapping("home")
    public String index(Model model) {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("112233");
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("save")
    @ResponseBody
    public ResponeData<User> save(@RequestBody User user) {
        return new ResponeData(user);
    }

    @GetMapping("sendMail")
    @ResponseBody
    public String sendMail() {
        MailAccount account = new MailAccount();
        account.setHost("smtp.126.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("zhangweiweikol@126.com");
        account.setUser("zhangweiweikol@126.com");
        account.setPass("kol262323");
        MailUtil.send(account, CollUtil.newArrayList("15542449355@163.com"),
                "测试", "邮件来自Hutool测试", false);
        return "success";
    }

    @GetMapping("test")
    @ResponseBody
    public String test() {
        TimeInterval ti = DateUtil.timer();
        String jsonStr = "[{\"streetName\":\"津苑南路\",\"energySavingRateList\":[{\"strReportDate\":\"11111\",\"strTheoryElectDegree\":\"11111\",\"strRealElectDegree\":\"1111\",\"strSaveElectDegree\":\"1111\",\"strEnergySavingRate\":\"111\"}],\"abbreviate\":\"ses\"}]";
        System.out.println(ti.interval());
        return jsonStr;
    }
}
