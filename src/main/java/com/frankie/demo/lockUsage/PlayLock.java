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
            String result = "";
            for(int i = 0; i < Integer.MAX_VALUE; i++){
                result += String.valueOf(i);
            }
            System.out.println(LocalDateTime.now() + " doLock() end  ");
        } finally {
            lock.unlock();
        }
    }


    public void doLockInterruptibly(){
        try {
            lock.lockInterruptibly();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
