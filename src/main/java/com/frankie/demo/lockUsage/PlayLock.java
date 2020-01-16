package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/15 16:29
 */
public class PlayLock {

    private Lock lock = new ReentrantLock();

    public void doLock(){
        try {
            lock.lock();
            System.out.println(LocalDateTime.now() + " doLock() start");
            doLongTimeJob();
            System.out.println(LocalDateTime.now() + " doLock() end  ");
        } finally {
            lock.unlock();
        }
    }


    public void doLockInterruptibly(){
        try {
            lock.lockInterruptibly();
            System.out.println(LocalDateTime.now() + " doLockInterruptibly() start");
            doLongTimeJob();
            System.out.println(LocalDateTime.now() + " doLockInterruptibly() end  ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void doLongTimeJob(){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            for(int j = 0; j < 100000; j++){
                Object o = new Object();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Cost " + (end - start));
    }

    public void doTryLock(){
        if (lock.tryLock()){
            System.out.println(Thread.currentThread().getName() + " get lock.");
        } else {
            System.out.println(Thread.currentThread().getName() + " does not get lock.");
        }
    }
}
