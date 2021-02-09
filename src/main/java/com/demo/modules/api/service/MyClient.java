package com.demo.modules.api.service;

import com.dtflys.forest.annotation.Request;

public interface MyClient {

    @Request(url = "http://www.weather.com.cn/data/sk/101010100.html")
    String helloForest();
}
