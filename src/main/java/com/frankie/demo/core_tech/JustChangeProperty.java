package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/10 21:28
 */
public class JustChangeProperty {

    public void justChangeProperty(Order order){
        synchronized (order){
            System.out.println(LocalDateTime.now() + " current thread = " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " current thread = " + Thread.currentThread().getName());
        }
    }
}
