package com.demo.platform.common.utils;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MonitorUtil {

    public static void main(String[] args) throws InterruptedException {
        getOsInfo();
        getCpuInfo();
        getMemInfo();
        getJvmInfo();
    }

    public static void getMemInfo(){
        SystemInfo systemInfo = new SystemInfo();
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        //总内存
        long totalByte = memory.getTotal();
        //剩余
        long acaliableByte = memory.getAvailable();
        System.out.println(formatByte(totalByte)); // 总内存
        System.out.println(formatByte(totalByte-acaliableByte)); // 使用
        System.out.println(formatByte(acaliableByte)); // 剩余内存
        System.out.println(new DecimalFormat("#.##%").format((totalByte-acaliableByte)*1.0/totalByte)); // 使用率
    }

    public static void getCpuInfo() throws InterruptedException {
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        // 睡眠1s
        TimeUnit.SECONDS.sleep(1);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;

        System.out.println("" + processor.getLogicalProcessorCount()); // cpu核数
        System.out.println(new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu)); // cpu系统使用率
        System.out.println(new DecimalFormat("#.##%").format(user * 1.0 / totalCpu)); // cpu用户使用率
        System.out.println(new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu)); // cpu当前等待率
        System.out.println(new DecimalFormat("#.##%").format(1.0-(idle * 1.0 / totalCpu))); // cpu当前使用率
    }

    public static void getOsInfo(){
        Properties props = System.getProperties();
        //系统名称
        String osName = props.getProperty("os.name");
        //架构名称
        String osArch = props.getProperty("os.arch");

        System.out.println(osName); // 操作系统名
        System.out.println(osArch); // 系统架构
    }

    public static void getJvmInfo(){
        Properties props = System.getProperties();
        Runtime runtime = Runtime.getRuntime();
        //jvm总内存
        long jvmTotalMemoryByte = runtime.totalMemory();
        //jvm最大可申请
        long jvmMaxMoryByte = runtime.maxMemory();
        //空闲空间
        long freeMemoryByte = runtime.freeMemory();
        //jdk版本
        String jdkVersion = props.getProperty("java.version");
        //jdk路径
        String jdkHome = props.getProperty("java.home");
        System.out.println(formatByte(jvmTotalMemoryByte)); // jvm内存总量
        System.out.println(formatByte(jvmTotalMemoryByte-freeMemoryByte)); // jvm已使用内存
        System.out.println(formatByte(freeMemoryByte)); // jvm剩余内存
        System.out.println(new DecimalFormat("#.##%").format((jvmTotalMemoryByte-freeMemoryByte)*1.0/jvmTotalMemoryByte)); // jvm内存使用率
        System.out.println(jdkVersion);
        System.out.println(jdkHome);
    }

    public static String formatByte(long byteNumber){
        //换算单位
        double FORMAT = 1024.0;
        double kbNumber = byteNumber/FORMAT;
        if(kbNumber<FORMAT){
            return new DecimalFormat("#.##KB").format(kbNumber);
        }
        double mbNumber = kbNumber/FORMAT;
        if(mbNumber<FORMAT){
            return new DecimalFormat("#.##MB").format(mbNumber);
        }
        double gbNumber = mbNumber/FORMAT;
        if(gbNumber<FORMAT){
            return new DecimalFormat("#.##GB").format(gbNumber);
        }
        double tbNumber = gbNumber/FORMAT;
        return new DecimalFormat("#.##TB").format(tbNumber);
    }

}
