package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/9 22:06
 */
public class DiffBetweenClassAndObjectLock {

    synchronized public static void staticMethodA(){
        System.out.println("Start static methodA at " + LocalDateTime.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End   static methodA at " + LocalDateTime.now());
    }

    synchronized public static void staticMethodB(){
        System.out.println("Start static methodB at " + LocalDateTime.now());
        System.out.println("End   static methodB at " + LocalDateTime.now());
    }

    synchronized public void methodC(){
        System.out.println("Start methodC at " + LocalDateTime.now());
        System.out.println("End   methodC at " + LocalDateTime.now());
    }
}
