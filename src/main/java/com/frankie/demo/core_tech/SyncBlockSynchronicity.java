package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/12 18:33
 */
public class SyncBlockSynchronicity {

    public void syncBlock1(){
        synchronized (this){
            System.out.println(LocalDateTime.now() + " syncBlock1() start in " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " syncBlock1() end   in " + Thread.currentThread().getName());
        }
    }

    public void syncBlock2(){
        synchronized (this){
            System.out.println(LocalDateTime.now() + " syncBlock2() start in " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " syncBlock2() end   in " + Thread.currentThread().getName());
        }
    }
}
