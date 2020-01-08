package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 21:44
 */
public class ExceptionReleaseLock {
    synchronized public void releaseALock(){
        if ("threadA".equals(Thread.currentThread().getName())){
            int i = 1;
            while (i < 1000){
                if (i == 999){
                    System.out.println(
                            "Current thread name " + Thread.currentThread().getName() +
                                    " run time " + LocalDateTime.now());
                    Integer.parseInt("a");
                }
                i++;
            }
        } else {
            System.out.println(
                    "Current thread name " + Thread.currentThread().getName() +
                    " run time " + LocalDateTime.now());
        }
    }
}
