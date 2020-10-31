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

    @GetMapping("test")
    @ResponseBody
    public String test() {
        String jsonStr = "{\n" +
                "\tpageNum: 1,\n" +
                "\tpageSize: 50,\n" +
                "\tsize: 0,\n" +
                "\tstartRow: 0,\n" +
                "\tendRow: 0,\n" +
                "\ttotal: 0,\n" +
                "\tpages: 0,\n" +
                "\tprePage: 0,\n" +
                "\tlist: [{\n" +
                "\t\t\"lampPostId\": \"lp101814695421280256\",\n" +
                "\t\t\"organId\": \"zm001\",\n" +
                "\t\t\"lampPostTypeName\": \"双臂灯\",\n" +
                "\t\t\"lampPostCode\": \"0123456433\",\n" +
                "\t\t\"aloneLampCount\": 2,\n" +
                "\t\t\"streetName\": \"经十路\",\n" +
                "\t\t\"streetSideName\": \"北侧\",\n" +
                "\t\t\"xTude\": 109.703982862289,\n" +
                "\t\t\"yTude\": 35.503025216873,\n" +
                "\t\t\"transformerName\": \"经十路控制箱\",\n" +
                "\t\t\"abbreviate\": \"lp\",\n" +
                "\t\t\"alonelamps\": [{\n" +
                "\t\t\t\t\"aloneLampNumber\": 1,\n" +
                "\t\t\t\t\"lampPower\": 200,\n" +
                "\t\t\t\t\"lampTypeName\": \"LED灯\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"aloneLampNumber\": 2,\n" +
                "\t\t\t\t\"lampPower\": 200,\n" +
                "\t\t\t\t\"lampTypeName\": \"LED灯\"\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t},{\n" +
                "\t\t\"lampPostId\": \"lp101814695421280257\",\n" +
                "\t\t\"organId\": \"zm001\",\n" +
                "\t\t\"lampPostTypeName\": \"双臂灯\",\n" +
                "\t\t\"lampPostCode\": \"0123456433\",\n" +
                "\t\t\"aloneLampCount\": 2,\n" +
                "\t\t\"streetName\": \"经十路\",\n" +
                "\t\t\"streetSideName\": \"北侧\",\n" +
                "\t\t\"xTude\": 109.703982862289,\n" +
                "\t\t\"yTude\": 35.503025216873,\n" +
                "\t\t\"transformerName\": \"经十路控制箱\",\n" +
                "\t\t\"abbreviate\": \"lp\",\n" +
                "\t\t\"alonelamps\": [{\n" +
                "\t\t\t\t\"aloneLampNumber\": 1,\n" +
                "\t\t\t\t\"lampPower\": 200,\n" +
                "\t\t\t\t\"lampTypeName\": \"LED灯\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"aloneLampNumber\": 2,\n" +
                "\t\t\t\t\"lampPower\": 200,\n" +
                "\t\t\t\t\"lampTypeName\": \"LED灯\"\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}]\n" +
                "}";
        return jsonStr;
    }
}
