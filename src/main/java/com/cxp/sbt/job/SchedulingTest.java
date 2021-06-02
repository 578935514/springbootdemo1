package com.cxp.sbt.job;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * springboot集成的Task定时任务实现，相对简单，但是不支持精确到年
 */
@Component
public class SchedulingTest {

    @Scheduled(fixedDelay = 3000)
    private void getTime() {
        LocalDateTime ldt = LocalDateTime.now();
        String time = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println("现在的时间：" + time);
    }

    /*
     * 定时任务每天12点执行
     * */
    @Scheduled(cron = "0 0 12 * * ? ")
    private void selectCountUser() {
        Logger logger = LoggerFactory.getLogger(SchedulingTest.class);

    }
}
