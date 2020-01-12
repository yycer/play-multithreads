package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 21:34
 */
public class ReentrantChildService extends ReentrantService {

    synchronized public void reentrantChildMethod(){
        System.out.println(LocalDateTime.now() + " reentrantChildMethod() start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.reentrantParentMethod();
        System.out.println(LocalDateTime.now() + " reentrantChildMethod() end");
    }

    public void childMethod(){
        System.out.println(LocalDateTime.now() + " childMethod() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " childMethod() end in " + Thread.currentThread().getName());
        this.parentSyncMethod();
    }
}
