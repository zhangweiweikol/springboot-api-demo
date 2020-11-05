package com.demo.modules.bussiness.controller;

import com.demo.platform.common.enums.ResultEnum;
import com.demo.platform.common.global.ResponeData;
import com.demo.platform.component.reids.RedisCacheManager;
import com.demo.platform.component.okhttp.OkHttpManager;
import com.demo.modules.bussiness.entity.ApiBuildingWebsite;
import com.demo.modules.bussiness.service.ApiBuildingWebsiteService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在建工地/工地总数(ApiBuildingWebsite)表控制层
 *
 * @author zhangweiwei
 * @since 2020-09-29 20:21:14
 */
@Controller
@RequestMapping("apiBuildingWebsite")
public class ApiBuildingWebsiteController {

    private static Logger logger = LoggerFactory.getLogger(ApiBuildingWebsiteController.class);

    /**
     * 服务对象
     */
    @Resource
    private ApiBuildingWebsiteService apiBuildingWebsiteService;

    @Resource
    OkHttpManager okHttpManager;

    @Resource
    RedisCacheManager redisCacheManager;

    @Autowired
    RedissonClient redissonClient;

    @Value("${test.name}")
    private String name;

    /**
     * 通过条件查询数据
     *
     * @return 多条数据
     */
    @GetMapping("queryAll")
    @ResponseBody
    public ResponeData<List<ApiBuildingWebsite>> queryAll() throws Exception {
        logger.info(name);

        RLock rLock = redissonClient.getLock("test1");
        rLock.lock();
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<ApiBuildingWebsite> list = this.apiBuildingWebsiteService.queryAll();


        rLock.unlock();

        return new ResponeData<>(ResultEnum.SUCCESS, list);
    }

}