package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/9 20:50
 */
public class DoubleSyncBlockOneObject {

    public void methodA(){
        synchronized (this){
            System.out.println("Start methodA at " + LocalDateTime.now());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End   methodA at " + LocalDateTime.now());
        }
    }

    public void methodB(){
        synchronized (this){
            System.out.println("Start methodB at " + LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End   methodB at " + LocalDateTime.now());
        }
    }
}
