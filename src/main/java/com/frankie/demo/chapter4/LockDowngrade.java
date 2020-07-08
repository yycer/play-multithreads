package com.frankie.demo.chapter4;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Yao Frankie
 * @date: 2020/7/7 13:46
 */
public class LockDowngrade {

    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock(false);

    void processCachedData(){
        rrwl.readLock().lock();
        if (!cacheValid){
            // 在获取写锁之前，必须释放读锁。
            rrwl.readLock().unlock();
            rrwl.writeLock().lock();
            try {
                // 防止在释放读锁，获取写锁的间隙，别的线程修改了数据。
                if (!cacheValid){
                    data = new Object();
                    cacheValid = true;
                }
                // 在不释放写锁的情况下，直接获取读锁，这就是读写锁的降级。
                rrwl.readLock().lock();
            } finally {
                // 释放写锁，但仍持有读锁。
                rrwl.writeLock().unlock();
            }
        }
        try {
            System.out.println(data);
        } finally {
            // 释放读锁。
            rrwl.readLock().unlock();
        }
    }

    public static void main(String[] args) {
//        AtomicLong
    }
}
