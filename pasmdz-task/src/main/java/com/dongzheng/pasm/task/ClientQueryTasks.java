package com.dongzheng.pasm.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *
 * </p>author
 *
 * @author xa
 * @since 2018-06-10
 */

@Component
public class ClientQueryTasks {

    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime(){
        System.out.println (Thread.currentThread().getName()+"Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date ()));
    }

    //每1分钟执行一次
    @Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron(){
        System.out.println (Thread.currentThread().getName()+"Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }

}
