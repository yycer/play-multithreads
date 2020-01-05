package com.frankie.demo.utils;

/**
 * @author: Yao Frankie
 * @date: 2020/1/5 14:22
 */
public class CommonOperationThread implements Runnable {

    public static int count = 0;

    @Override
    public void run() {
        System.out.println("Current thread name is " + Thread.currentThread().getName());
        for (int i = 0; i < 10000; i++){
            count++;
        }
    }
}
