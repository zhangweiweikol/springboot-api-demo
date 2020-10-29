package com.demo.modules.bussiness.service;

import com.demo.modules.bussiness.entity.ApiBuildingWebsite;

import java.util.List;

/**
 * 在建工地/工地总数(ApiBuildingWebsite)表服务接口
 *
 * @author zhangweiwei
 * @since 2020-09-29 20:21:14
 */
public interface ApiBuildingWebsiteService {

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<ApiBuildingWebsite> queryAll();

}