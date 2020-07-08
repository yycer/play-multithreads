package com.frankie.demo.chapter4;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Yao Frankie
 * @date: 2020/7/7 11:42
 */
public class ReadLockWaitDemo {

    private static final ReentrantReadWriteLock rReadWriteLock = new ReentrantReadWriteLock(false);

    private static void read(){
        rReadWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取。");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rReadWriteLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + "释放读锁。");
        }
    }

    private static void write(){
        rReadWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入。");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rReadWriteLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + "释放写锁。");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> read(),  "Thread1").start();
        new Thread(() -> read(),  "Thread2").start();
        new Thread(() -> write(), "Thread3").start();
        new Thread(() -> read(),  "Thread4").start();
    }
}
