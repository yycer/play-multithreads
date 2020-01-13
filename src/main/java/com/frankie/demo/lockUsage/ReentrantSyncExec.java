package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 10:40
 */
public class ReentrantSyncExec {

    private Lock lock = new ReentrantLock();

    public void method1(){
        lock.lock();
        System.out.println(LocalDateTime.now() + " method1() start in " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println(LocalDateTime.now() + " method1() end   in " + Thread.currentThread().getName());
    }

    public void method2(){
        lock.lock();
        System.out.println(LocalDateTime.now() + " method2() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println(LocalDateTime.now() + " method2() end   in " + Thread.currentThread().getName());
    }

}
