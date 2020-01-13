package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 13:18
 */
public class PrintAlternatively {

    private Object object       = new Object();
    private Lock reentrantLock  = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public void printOddNumberUsingWaitAndNotify(){
        synchronized (object){
            for(int i = 1; i < 10; i += 2){
                object.notify();
                System.out.println(LocalDateTime.now() + " i = " + i + " in " + Thread.currentThread().getName());
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printEvenNumberUsingWaitAndNotify(){
        synchronized (object){
            for(int i = 2; i <= 10; i += 2){
                object.notify();
                System.out.println(LocalDateTime.now() + " i = " + i + " in " + Thread.currentThread().getName());
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printOddNumberUsingCondition(){
        reentrantLock.lock();
        for(int i = 1; i < 10; i += 2){
            condition.signal();
            System.out.println(LocalDateTime.now() + " i = " + i + " in " + Thread.currentThread().getName());
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        reentrantLock.unlock();
    }

    public void printEvenNumberUsingCondition(){
        reentrantLock.lock();
        for(int i = 2; i <= 10; i += 2){
            condition.signal();
            System.out.println(LocalDateTime.now() + " i = " + i + " in " + Thread.currentThread().getName());
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        reentrantLock.unlock();
    }
}





















