package com.frankie.demo.chapter3;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @author: Yao Frankie
 * @date: 2020/7/6 11:27
 */
public class ScheduleTest {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledThreadPool = Executors
                .newScheduledThreadPool(10);

        System.out.println("Start " + LocalDateTime.now());
        Runnable task3 = () -> {
            System.out.println("task3 " + LocalDateTime.now());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
//         scheduledThreadPool.schedule(task3, 3, TimeUnit.SECONDS);
//         scheduledThreadPool.scheduleAtFixedRate(task3, 3, 5, TimeUnit.SECONDS);
         scheduledThreadPool.scheduleWithFixedDelay(task3, 3, 5, TimeUnit.SECONDS);

        System.out.println("End   " + LocalDateTime.now());

        scheduledThreadPool.awaitTermination(20, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }
}
