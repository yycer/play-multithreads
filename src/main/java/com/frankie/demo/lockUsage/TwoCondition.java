package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 13:06
 */
public class TwoCondition {

    private Lock reentrantLock   = new ReentrantLock();
    private Condition condition1 = reentrantLock.newCondition();
    private Condition condition2 = reentrantLock.newCondition();

    public void awaitA(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " awaitA()  start in " + Thread.currentThread().getName());
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(LocalDateTime.now() + " awaitA()  end   in " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    public void awaitB(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " awaitB()  start in " + Thread.currentThread().getName());
            condition2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(LocalDateTime.now() + " awaitB()  end   in " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    public void signalA(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " signalA() start in " + Thread.currentThread().getName());
            condition1.signalAll();
        } finally {
            System.out.println(LocalDateTime.now() + " signalA() end   in " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    public void signalB(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " signalB() start in " + Thread.currentThread().getName());
            condition2.signalAll();
        } finally {
            System.out.println(LocalDateTime.now() + " signalB() end   in " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }
}
