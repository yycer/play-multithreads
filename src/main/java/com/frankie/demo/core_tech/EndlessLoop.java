package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/10 22:10
 */
public class EndlessLoop {

    private boolean isContinuePrint = true;

    public boolean isContinuePrint(){
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint){
        this.isContinuePrint = isContinuePrint;
        System.out.println(LocalDateTime.now() + " current thread = " + Thread.currentThread().getName() +
                ", isContinuePrint = " + isContinuePrint);
    }

    public void print(){
        try {
            while (isContinuePrint()){
                System.out.println(LocalDateTime.now() + " current thread = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
