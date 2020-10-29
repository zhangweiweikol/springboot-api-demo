package com.demo.modules.task;

import com.github.kfcfans.powerjob.worker.core.processor.ProcessResult;
import com.github.kfcfans.powerjob.worker.core.processor.TaskContext;
import com.github.kfcfans.powerjob.worker.core.processor.sdk.BasicProcessor;
import com.github.kfcfans.powerjob.worker.log.OmsLogger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BasicProcessorDemo implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext context) throws Exception {

        // 在线日志功能，可以直接在控制台查看任务日志，非常便捷
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("BasicProcessorDemo start to process, current JobParams is {}.", context.getJobParams());

        // TaskContext为任务的上下文信息，包含了在控制台录入的任务元数据，常用字段为
        // jobParams（任务参数，在控制台录入），instanceParams（任务实例参数，通过 OpenAPI 触发的任务实例才可能存在该参数）

        // 进行实际处理...
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        System.out.println("######################################");
        // 返回结果，该结果会被持久化到数据库，在前端页面直接查看，极为方便
        return new ProcessResult(true, "result is xxx");
    }
}