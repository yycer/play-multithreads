package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/9 20:42
 */
public class HalfAsyncHalfSync {

    public void doLongTimeTask(){
        for (int i = 1; i <= 100; i++){
            System.out.println(
                    "Async current thread name = " + Thread.currentThread().getName() +
                    " , i = " + i);
        }
        synchronized (this){
            for (int i = 1; i <= 100; i++){
                System.out.println(
                        "Sync current thread name = " + Thread.currentThread().getName() +
                                " , i = " + i);
            }
        }
    }

    synchronized public void syncMethodA(){
        System.out.println("Start sync methodA at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End   sync methodA at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
    }

    public void methodB(){
        System.out.println("Start methodB at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End   methodB at " + LocalDateTime.now() + ", in " + Thread.currentThread().getName());
    }

}
