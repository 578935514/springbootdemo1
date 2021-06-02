package com.cxp.sbt.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Configurable
@Component
@EnableScheduling
public class ScheduleQuartz {


    // 1、创建调度器Scheduler
    SchedulerFactory schedulerFactory = new StdSchedulerFactory();


    public void test() throws SchedulerException, InterruptedException {
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 2、创建JobDetail实例，并与PrintTimeJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintTimeJob.class)
                .usingJobData("jobDetail1", "这个Job用来测试的")
                .withIdentity("job1", "group1").build();

        // 3、构建Trigger实例,每隔1s执行一次
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .usingJobData("trigger1", "这是jobDetail1的trigger")
                .startNow()//立即生效
                //.startAt(startDate)//什么时候开始执行
                //.endAt(endDate)//什么时候结束
                .withSchedule(CronScheduleBuilder.cronSchedule("* 30 10 ? * 1/5 2021"))
                .build();

        //4、执行
        scheduler.scheduleJob(jobDetail, cronTrigger);
        System.out.println("-----------------scheduler开始执行-----------------");
        scheduler.start();

        //5、休眠
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("-----------------scheduler结束-----------------");


    }

    @Bean
    //创建定时任务
    public JobDetail testQuartz1() {
        return JobBuilder.newJob(PrintTimeJob.class).withIdentity("testTask1").storeDurably().build();
    }

    @Bean
    //创建出发器
    public Trigger testQuartzTrigger1() {
        //5秒执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testQuartz1())
                .withIdentity("testTask1")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail testQuartz2() {
        return JobBuilder.newJob(PrintTimeJob.class).withIdentity("testTask2").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger2() {
        //cron方式，每隔5秒执行一次
        return TriggerBuilder.newTrigger().forJob(testQuartz1())
                .withIdentity("testTask2")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();
    }

    public void quartzRun() throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        //4、执行
        scheduler.scheduleJob(testQuartz1(), testQuartzTrigger1());
        System.out.println("-----------------scheduler开始执行-----------------");
        scheduler.start();
    }

    public static void main(String[] args) throws SchedulerException {
        ScheduleQuartz scheduleQuartz = new ScheduleQuartz();
        scheduleQuartz.quartzRun();
    }


}
