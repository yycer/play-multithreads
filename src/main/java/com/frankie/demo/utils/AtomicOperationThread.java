package com.frankie.demo.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Yao Frankie
 * @date: 2020/1/5 14:28
 */
public class AtomicOperationThread implements Runnable{

    public static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println("Current thread name is " + Thread.currentThread().getName());
        for (int i = 0; i < 100000; i++){
            count.incrementAndGet();
        }
    }
}
