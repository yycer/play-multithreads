package com.frankie.demo.lockUsage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 15:57
 */
public class FairnessLock {

    private Lock reentrantLock;

    public void setFairness(boolean isFairness){
        reentrantLock = new ReentrantLock(isFairness);
    }

    public void run(){
        for(int i = 0; i < 5; i++){
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock.");
            reentrantLock.unlock();
        }
    }
}
