package com.frankie.demo.chapter7;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 21:49
 */
public class VolatileDemo {

    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            while (flag) {
                System.out.println("Flag is true");
            }
        };

        Thread t2 = new Thread(() -> {
            flag = false;
            System.out.println("Flag is false!!!");
        });

        ThreadPoolExecutor service = new ThreadPoolExecutor(
                16, 100, 5L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100; i++){
            service.submit(task);
        }

        t2.start();
        service.shutdownNow();
    }
}
