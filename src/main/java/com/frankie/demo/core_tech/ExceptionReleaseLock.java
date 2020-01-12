package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 21:44
 */
public class ExceptionReleaseLock {
    synchronized public void releaseALock(){
        if ("threadA".equals(Thread.currentThread().getName())){
            for (int i = 0; i < 1000000; i++){
                if (i == 999999){
                    System.out.println(
                            "Current thread name " + Thread.currentThread().getName() +
                             " run time " + LocalDateTime.now());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println(
                    "Current thread name " + Thread.currentThread().getName() +
                    " run time " + LocalDateTime.now());
        }
    }
}
