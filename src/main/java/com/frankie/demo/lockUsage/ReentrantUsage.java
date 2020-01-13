package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 11:21
 */
public class ReentrantUsage {

    private Lock reentrantLock   = new ReentrantLock();
    private Condition condition1 = reentrantLock.newCondition();

    public void await(){
        reentrantLock.lock();
        System.out.println("await() method start.");
        try {
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("await() method end.  ");
        reentrantLock.unlock();
    }

    public void awaitCorrectUsage(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " awaitCorrectUsage()  start in " + Thread.currentThread().getName());
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void signalCorrectUsage(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " signalCorrectUsage() start in " + Thread.currentThread().getName());
            condition1.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void awaitA(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " awaitA() method start in " + Thread.currentThread().getName());
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(LocalDateTime.now() + " awaitA() method end.  in " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    public void awaitB(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " awaitB() method end.  in " + Thread.currentThread().getName());
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(LocalDateTime.now() + " awaitB() method end.  in " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    public void signalAll(){
        try {
            reentrantLock.lock();
            System.out.println(LocalDateTime.now() + " signalAll() method end.  in " + Thread.currentThread().getName());
            condition1.signalAll();
        } finally {
            System.out.println(LocalDateTime.now() + " signalAll() method end.  in " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }
}
