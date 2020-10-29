package com.demo.modules.bussiness.controller;

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
}
