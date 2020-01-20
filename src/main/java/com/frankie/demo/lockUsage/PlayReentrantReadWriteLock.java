package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/20 10:44
 */
public class PlayReentrantReadWriteLock {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        try {
            lock.readLock().lock();
            System.out.println(LocalDateTime.now() + " [" + Thread.currentThread().getName() + "] "
                + "enter read()");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        try {
            lock.writeLock().lock();
            System.out.println(LocalDateTime.now() + " [" + Thread.currentThread().getName() + "] "
                    + "enter write()");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
