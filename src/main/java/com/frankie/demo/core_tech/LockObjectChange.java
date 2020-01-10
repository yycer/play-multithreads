package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/10 21:23
 */
public class LockObjectChange {

    public String lock = "123";

    public void justPrint(){
        synchronized (lock){
            System.out.println(LocalDateTime.now() + " current thread = " + Thread.currentThread().getName());
            lock = "456";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " current thread = " + Thread.currentThread().getName());
        }
    }
}
