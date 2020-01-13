package com.frankie.demo.lockUsage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 10:34
 */
public class ReentrantBeginning {

    private Lock reentrantLock = new ReentrantLock();

    public void printNum(){
        reentrantLock.lock();
        for(int i = 0; i < 5; i++){
            System.out.println("Current thread: " + Thread.currentThread().getName() + " , i = " + i);
        }
        reentrantLock.unlock();
    }
}
