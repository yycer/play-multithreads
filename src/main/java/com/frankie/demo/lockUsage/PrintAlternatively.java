package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 13:18
 */
public class PrintAlternatively {

    Object o = new Object();

    public void printOddNumberUsingWaitAndNotify(){
        synchronized (o){
            for(int i = 1; i < 10; i += 2){
                o.notifyAll();
                System.out.println(LocalDateTime.now() + " i = " + i + " in " + Thread.currentThread().getName());
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printEvenNumberUsingWaitAndNotify(){
        synchronized (o){
            for(int i = 2; i <= 10; i += 2){
                o.notifyAll();
                System.out.println(LocalDateTime.now() + " i = " + i + " in " + Thread.currentThread().getName());
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
