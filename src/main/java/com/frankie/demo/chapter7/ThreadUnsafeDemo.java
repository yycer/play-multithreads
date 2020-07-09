package com.frankie.demo.chapter7;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 08:05
 */
public class ThreadUnsafeDemo {

    public static int ans = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++){
                ans++;
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // ans = 12633
        System.out.println("ans = " + ans);
    }
}
