package com.demo.modules.bussiness.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.demo.modules.bussiness.entity.User;
import com.demo.platform.common.global.ResponeData;
import com.demo.platform.common.utils.EMailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        String jsonStr = "{\n" +
                "  \"pageIndex\": 1,\n" +
                "  \"pageSize\": 100000,\n" +
                "  \"totalCount\": 29,\n" +
                "  \"pageCount\": 1,\n" +
                "  \"list\": [\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308670894080\",\n" +
                "      \"LampPostCode\": \"津苑南路001\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 1,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308746391552\",\n" +
                "          \"aloneLampControlId\": \"ac437425308687671296\",\n" +
                "          \"productNumber\": \"174307601198\",\n" +
                "          \"addressCode\": \"174307601198\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425113950330880\",\n" +
                "      \"LampPostCode\": \"津苑南路002\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 1,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114017439744\",\n" +
                "          \"aloneLampControlId\": \"ac437425113996468224\",\n" +
                "          \"productNumber\": \"180407601243\",\n" +
                "          \"addressCode\": \"180407601243\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308763168768\",\n" +
                "      \"LampPostCode\": \"津苑南路003\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 2,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308775751680\",\n" +
                "          \"aloneLampControlId\": \"ac437425308767363072\",\n" +
                "          \"productNumber\": \"174307601219\",\n" +
                "          \"addressCode\": \"174307601219\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114025828352\",\n" +
                "      \"LampPostCode\": \"津苑南路004\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 2,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114046799872\",\n" +
                "          \"aloneLampControlId\": \"ac437425114034216960\",\n" +
                "          \"productNumber\": \"174307601223\",\n" +
                "          \"addressCode\": \"174307601223\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308788334592\",\n" +
                "      \"LampPostCode\": \"津苑南路005\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 3,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308813500416\",\n" +
                "          \"aloneLampControlId\": \"ac437425308796723200\",\n" +
                "          \"productNumber\": \"174307601218\",\n" +
                "          \"addressCode\": \"174307601218\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114055188480\",\n" +
                "      \"LampPostCode\": \"津苑南路006\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 3,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114101325824\",\n" +
                "          \"aloneLampControlId\": \"ac437425114076160000\",\n" +
                "          \"productNumber\": \"174307601221\",\n" +
                "          \"addressCode\": \"174307601221\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308834471936\",\n" +
                "      \"LampPostCode\": \"津苑南路007\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 4,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308863832064\",\n" +
                "          \"aloneLampControlId\": \"ac437425308851249152\",\n" +
                "          \"productNumber\": \"174307601220\",\n" +
                "          \"addressCode\": \"174307601220\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114109714432\",\n" +
                "      \"LampPostCode\": \"津苑南路008\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 4,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114134880256\",\n" +
                "          \"aloneLampControlId\": \"ac437425114118103040\",\n" +
                "          \"productNumber\": \"180407601244\",\n" +
                "          \"addressCode\": \"180407601244\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308876414976\",\n" +
                "      \"LampPostCode\": \"津苑南路009\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 5,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308901580800\",\n" +
                "          \"aloneLampControlId\": \"ac437425308893192192\",\n" +
                "          \"productNumber\": \"174307604059\",\n" +
                "          \"addressCode\": \"174307604059\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114143268864\",\n" +
                "      \"LampPostCode\": \"津苑南路010\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 5,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114155851776\",\n" +
                "          \"aloneLampControlId\": \"ac437425114147463168\",\n" +
                "          \"productNumber\": \"174307604052\",\n" +
                "          \"addressCode\": \"174307604052\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308909969408\",\n" +
                "      \"LampPostCode\": \"津苑南路011\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 6,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308930940928\",\n" +
                "          \"aloneLampControlId\": \"ac437425308918358016\",\n" +
                "          \"productNumber\": \"180407601247\",\n" +
                "          \"addressCode\": \"180407601247\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114164240384\",\n" +
                "      \"LampPostCode\": \"津苑南路012\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 6,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114185211904\",\n" +
                "          \"aloneLampControlId\": \"ac437425114172628992\",\n" +
                "          \"productNumber\": \"174307601222\",\n" +
                "          \"addressCode\": \"174307601222\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308943523840\",\n" +
                "      \"LampPostCode\": \"津苑南路013\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 7,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308960301056\",\n" +
                "          \"aloneLampControlId\": \"ac437425308943523841\",\n" +
                "          \"productNumber\": \"174307604111\",\n" +
                "          \"addressCode\": \"174307604111\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114193600512\",\n" +
                "      \"LampPostCode\": \"津苑南路014\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 7,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114210377728\",\n" +
                "          \"aloneLampControlId\": \"ac437425114197794816\",\n" +
                "          \"productNumber\": \"174307604056\",\n" +
                "          \"addressCode\": \"174307604056\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308972883968\",\n" +
                "      \"LampPostCode\": \"津苑南路015\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 8,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425308989661184\",\n" +
                "          \"aloneLampControlId\": \"ac437425308981272576\",\n" +
                "          \"productNumber\": \"174307601201\",\n" +
                "          \"addressCode\": \"174307601201\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114218766336\",\n" +
                "      \"LampPostCode\": \"津苑南路016\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 8,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114235543552\",\n" +
                "          \"aloneLampControlId\": \"ac437425114227154944\",\n" +
                "          \"productNumber\": \"174307601199\",\n" +
                "          \"addressCode\": \"174307601199\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425308998049792\",\n" +
                "      \"LampPostCode\": \"津苑南路017\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 9,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425309019021312\",\n" +
                "          \"aloneLampControlId\": \"ac437425309006438400\",\n" +
                "          \"productNumber\": \"180407601245\",\n" +
                "          \"addressCode\": \"180407601245\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114243932160\",\n" +
                "      \"LampPostCode\": \"津苑南路018\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 9,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114264903680\",\n" +
                "          \"aloneLampControlId\": \"ac437425114252320768\",\n" +
                "          \"productNumber\": \"174307604057\",\n" +
                "          \"addressCode\": \"174307604057\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425309031604224\",\n" +
                "      \"LampPostCode\": \"津苑南路019\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 10,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425309048381440\",\n" +
                "          \"aloneLampControlId\": \"ac437425309039992832\",\n" +
                "          \"productNumber\": \"174307601200\",\n" +
                "          \"addressCode\": \"174307601200\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114281680896\",\n" +
                "      \"LampPostCode\": \"津苑南路020\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 10,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114298458112\",\n" +
                "          \"aloneLampControlId\": \"ac437425114290069504\",\n" +
                "          \"productNumber\": \"180407601246\",\n" +
                "          \"addressCode\": \"180407601246\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425309056770048\",\n" +
                "      \"LampPostCode\": \"津苑南路021\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 11,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425309077741568\",\n" +
                "          \"aloneLampControlId\": \"ac437425309065158656\",\n" +
                "          \"productNumber\": \"174307601202\",\n" +
                "          \"addressCode\": \"174307601202\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114306846720\",\n" +
                "      \"LampPostCode\": \"津苑南路022\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 11,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114319429633\",\n" +
                "          \"aloneLampControlId\": \"ac437425114315235328\",\n" +
                "          \"productNumber\": \"174307604055\",\n" +
                "          \"addressCode\": \"174307604055\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425309090324480\",\n" +
                "      \"LampPostCode\": \"津苑南路023\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 12,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425309115490304\",\n" +
                "          \"aloneLampControlId\": \"ac437425309102907392\",\n" +
                "          \"productNumber\": \"174307601203\",\n" +
                "          \"addressCode\": \"174307601203\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114327818240\",\n" +
                "      \"LampPostCode\": \"津苑南路024\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 12,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114348789760\",\n" +
                "          \"aloneLampControlId\": \"ac437425114336206848\",\n" +
                "          \"productNumber\": \"180407601248\",\n" +
                "          \"addressCode\": \"180407601248\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425309123878912\",\n" +
                "      \"LampPostCode\": \"津苑南路025\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 13,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425309157433344\",\n" +
                "          \"aloneLampControlId\": \"ac437425309136461824\",\n" +
                "          \"productNumber\": \"174307601224\",\n" +
                "          \"addressCode\": \"174307601224\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114352984064\",\n" +
                "      \"LampPostCode\": \"津苑南路026\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 13,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114373955584\",\n" +
                "          \"aloneLampControlId\": \"ac437425114361372672\",\n" +
                "          \"productNumber\": \"174307604060\",\n" +
                "          \"addressCode\": \"174307604060\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425309165821952\",\n" +
                "      \"LampPostCode\": \"津苑南路027\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 14,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425309186793472\",\n" +
                "          \"aloneLampControlId\": \"ac437425309178404864\",\n" +
                "          \"productNumber\": \"174307604061\",\n" +
                "          \"addressCode\": \"174307604061\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425114382344192\",\n" +
                "      \"LampPostCode\": \"津苑南路028\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 14,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133033000796160\",\n" +
                "      \"StreetSideName\": \"北侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425114399121408\",\n" +
                "          \"aloneLampControlId\": \"ac437425114390732800\",\n" +
                "          \"productNumber\": \"174307604063\",\n" +
                "          \"addressCode\": \"174307604063\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"节能灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"LampPostID\": \"lp437425309203570688\",\n" +
                "      \"LampPostCode\": \"津苑南路029\",\n" +
                "      \"BaiduX\": \"118.261894000000\",\n" +
                "      \"BaiduY\": \"37.496100000000\",\n" +
                "      \"LampPostType\": \"单臂灯\",\n" +
                "      \"LampPostNumber\": 15,\n" +
                "      \"aloneLampCount\": 1,\n" +
                "      \"StreetID\": \"st437410541734469632\",\n" +
                "      \"StreetName\": \"津苑南路\",\n" +
                "      \"MaterialName\": \"铁杆\",\n" +
                "      \"StreetSideID\": \"ssd177133008858382336\",\n" +
                "      \"StreetSideName\": \"南侧\",\n" +
                "      \"WorkAreaName\": \"利津\",\n" +
                "      \"wgs84x_tude\": 118.249393951218,\n" +
                "      \"wgs84y_tude\": 37.489667260666,\n" +
                "      \"protocolType\": 0,\n" +
                "      \"AloneLamps\": [\n" +
                "        {\n" +
                "          \"AloneLampId\": \"al437425309224542208\",\n" +
                "          \"aloneLampControlId\": \"ac437425309216153600\",\n" +
                "          \"productNumber\": \"174307603597\",\n" +
                "          \"addressCode\": \"174307603597\",\n" +
                "          \"EffectId\": \"le436677220662517760\",\n" +
                "          \"Effect\": \"主干道\",\n" +
                "          \"EnergyType\": \"调光\",\n" +
                "          \"IsOnline\": false,\n" +
                "          \"IsSwitchOn\": false,\n" +
                "          \"LampPower\": 100.0,\n" +
                "          \"LampType\": \"LED灯\",\n" +
                "          \"LampCode\": \"1\",\n" +
                "          \"LampNumber\": 1,\n" +
                "          \"rtuCode\": \"05460001\",\n" +
                "          \"rtuRoadId\": \"rrd437411082392838144\",\n" +
                "          \"hitchAlarms\": []\n" +
                "        }\n" +
                "      ],\n" +
                "      \"rtuCode\": \"05460001\",\n" +
                "      \"rtuName\": \"津苑南路\",\n" +
                "      \"controlCabinetName\": \"津苑南路\",\n" +
                "      \"controlCabinetCode\": \"05460001\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return jsonStr;
    }
}
