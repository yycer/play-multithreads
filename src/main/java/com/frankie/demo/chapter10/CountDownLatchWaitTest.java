package com.frankie.demo.chapter10;

import sun.reflect.annotation.TypeAnnotationParser;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 19:48
 */
public class CountDownLatchWaitTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++){
            final int cur = i + 1;
            Runnable task = () -> {
                try {
                    Thread.sleep((long) (Math.random() * 5000));
                    System.out.println(cur + "号运动员已完成比赛");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            };
            service.submit(task);
        }
        System.out.println("等待5个运动员都跑完");
        System.out.println("-----------------------");
        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("比赛结束。");
        service.shutdown();

//        等待5个运动员都跑完
//        -----------------------
//        1号运动员已完成比赛
//        4号运动员已完成比赛
//        5号运动员已完成比赛
//        2号运动员已完成比赛
//        3号运动员已完成比赛
//        比赛结束。
    }
}
