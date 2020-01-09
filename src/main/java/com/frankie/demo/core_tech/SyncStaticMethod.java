package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/9 21:59
 */
public class SyncStaticMethod {

    synchronized public static void methodA(){
        System.out.println("Start methodA at " + LocalDateTime.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End   methodA at " + LocalDateTime.now());
    }

    synchronized public static void methodB(){
        System.out.println("Start methodB at " + LocalDateTime.now());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End   methodB at " + LocalDateTime.now());
    }
}
