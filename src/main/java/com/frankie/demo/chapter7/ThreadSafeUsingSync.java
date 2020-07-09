package com.frankie.demo.chapter7;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 08:08
 */
public class ThreadSafeUsingSync implements Runnable{

    public static int ans = 0;

    public static void main(String[] args) throws InterruptedException {

        ThreadSafeUsingSync task = new ThreadSafeUsingSync();

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // ans = 20000
        System.out.println("ans = " + ans);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            synchronized (this){
                ans++;
            }
        }
    }
}
