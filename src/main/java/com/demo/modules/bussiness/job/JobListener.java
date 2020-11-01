package com.demo.modules.bussiness.job;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

public class JobListener implements ElasticJobListener {
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("####################### beforeJobExecuted #################################");
        System.out.println(shardingContexts.toString());
        System.out.println("####################### beforeJobExecuted #################################");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("####################### afterJobExecuted #################################");
        System.out.println(shardingContexts.toString());
        System.out.println("####################### afterJobExecuted #################################");
    }
}
