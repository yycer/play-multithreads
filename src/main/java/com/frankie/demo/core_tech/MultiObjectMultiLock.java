package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/12 14:58
 */
public class MultiObjectMultiLock {

    synchronized public void methodA(){
        System.out.println("Start methodA at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End   methodA at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
    }

    synchronized public void methodB(){
        System.out.println("Start methodB at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End   methodB at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
    }
}
