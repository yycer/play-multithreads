package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/12 18:16
 */
public class SyncMethodDisadvantage {

    private String processResult = "Done";

    synchronized public void syncMethod(){
        System.out.println(LocalDateTime.now() + " syncMethod() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " processResult = " + processResult);
        System.out.println(LocalDateTime.now() + " syncMethod() end   in " + Thread.currentThread().getName());
    }

    public void syncBlock(){
        System.out.println(LocalDateTime.now() + " syncMethod() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            System.out.println(LocalDateTime.now() + " processResult = " + processResult);
        }
        System.out.println(LocalDateTime.now() + " syncMethod() end   in " + Thread.currentThread().getName());
    }
}
