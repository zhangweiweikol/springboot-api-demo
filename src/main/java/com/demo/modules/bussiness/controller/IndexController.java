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
        String jsonStr = "{\"pageNum\":1,\"pageSize\":100000,\"size\":0,\"startRow\":0,\"endRow\":0,\"total\":0,\"pages\":0,\"list\":[{\"hitchName\":\"1111\",\"lampPostCode\":\"111\",\"lampEffect\":\"111\",\"occurDate\":\"111\",\"organId\":\"111\"}],\"prePage\":0,\"nextPage\":0,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[],\"navigateFirstPage\":0,\"navigateLastPage\":0}";
        System.out.println(ti.interval());
        return jsonStr;
    }
}
