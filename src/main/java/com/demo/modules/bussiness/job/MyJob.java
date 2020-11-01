package com.demo.modules.bussiness.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements com.dangdang.ddframe.job.api.simple.SimpleJob {

    @Override
    public void execute(final ShardingContext shardingContext) {
        System.out.println("===================================================");
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId(), "SIMPLE"));
        System.out.println("===================================================");

    }
}