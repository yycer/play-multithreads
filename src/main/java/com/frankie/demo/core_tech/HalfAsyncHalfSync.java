package com.frankie.demo.core_tech;

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
}
