package com.demo.modules.bussiness.service.impl;

import com.demo.modules.bussiness.dao.ApiBuildingWebsiteDao;
import com.demo.modules.bussiness.entity.ApiBuildingWebsite;
import com.demo.modules.bussiness.service.ApiBuildingWebsiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在建工地/工地总数(ApiBuildingWebsite)表服务实现类
 *
 * @author zhangweiwei
 * @since 2020-09-29 20:21:14
 */
@Service("apiBuildingWebsiteService")
public class ApiBuildingWebsiteServiceImpl implements ApiBuildingWebsiteService {

    @Resource
    private ApiBuildingWebsiteDao apiBuildingWebsiteDao;

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<ApiBuildingWebsite> queryAll() {
        return this.apiBuildingWebsiteDao.selectAll();
    }

}