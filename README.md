# springboot-api-demo
springboot开发脚手架。

详细包括：<br>
　　如何优雅停机、<br>
　　弃用tomcat容器改用undertow、<br>
　　连接数据库、<br>
　　redis、<br>
　　redisson、<br>
　　使用thymeleaf模板做视图、<br>
　　使用mybatis通用mapper、<br>
　　引入okhttp、<br>
　　引入elastic-job-lite、<br>
   集成分布式锁redisson、<br>
   集成h2数据库<br>
等等，方便开发时候使用。<br><br><br><br>


##redisson分布式锁：
###1、前提引入redis
###2、pom.xml引入：
```xml
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson-spring-boot-starter</artifactId>
    <version>3.13.6</version>
</dependency>
```
###3、添加配置文件《application-redisson.yml》
###4、代码写法
```java
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
```


##elastic-job-lite：
Elastic-Job-Lite是一个分布式调度解决方案，定位为轻量级无中心化解决方案，使用jar包的形式提供分布式任务的协调服务。
###1、pom.xml引入：
```xml
<dependency>
    <groupId>com.github.xjzrc.spring.boot</groupId>
    <artifactId>elastic-job-lite-spring-boot-starter</artifactId>
    <version>2.0.0</version>
</dependency>
```
###2、添加配置文件《application-elasticjob.yml》

```
spring:
  main:
    allow-bean-definition-overriding: true
  elasticjob:
    #注册中心配置
    zookeeper:
      server-lists: 192.168.0.205:2181
      namespace: dd-job01
    #简单作业配置
    simples:
      #spring简单作业示例配置
      spring-simple-job:
        #配置简单作业，必须实现com.dangdang.ddframe.job.api.simple.SimpleJob
        job-class: com.demo.modules.bussiness.job.MyJob
        cron: 0/2 * * * * ?
        sharding-total-count: 3
        sharding-item-parameters: 0=Beijing,1=Shanghai,2=Guangzhou
        #配置监听器
        listener:
          #配置每台作业节点均执行的监听，必须实现com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener
          listener-class: com.demo.modules.bussiness.job.JobListener
      #spring简单作业示例配置
      spring-simple-job1:
        #配置简单作业，必须实现com.dangdang.ddframe.job.api.simple.SimpleJob
        job-class: com.demo.modules.bussiness.job.MyJob1
        cron: 0/2 * * * * ?
        sharding-total-count: 3
        sharding-item-parameters: 0=Beijing,1=Shanghai,2=Guangzhou
        #配置监听器
        listener:
          #配置每台作业节点均执行的监听，必须实现com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener
          listener-class: com.demo.modules.bussiness.job.JobListener
```

spring-simple-job和spring-simple-job1 代表两个不同的任务。

任务的分片需要代码里进行相应的处理，比如配置<br>
sharding-total-count: 3
即分成三片， 代码里比如查询一张表 id可以和3取余，结果为1的为一片，结果为2的为一片，结果为3的为一片。
