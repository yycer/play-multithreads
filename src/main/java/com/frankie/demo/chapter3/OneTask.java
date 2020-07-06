package com.frankie.demo.chapter3;

import java.util.concurrent.*;

/**
 * @author: Yao Frankie
 * @date: 2020/7/6 09:11
 */
public class OneTask {

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++){
//            new Thread(() -> {
//                System.out.println("Thread name: " + Thread.currentThread().getName());
//            }).start();
//        }

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++){
            pool.submit(() -> {
                System.out.println("Thread name: " + Thread.currentThread().getName());
            });
        }


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy());


        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    }
}
