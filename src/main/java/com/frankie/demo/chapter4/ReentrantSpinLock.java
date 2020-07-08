package com.frankie.demo.chapter4;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyStore;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: Yao Frankie
 * @date: 2020/7/7 14:16
 */
public class ReentrantSpinLock {

    // 当前锁被哪个线程锁持有
    private AtomicReference<Thread> owner = new AtomicReference<>();

    // 锁重入次数
    private int count = 0;

    public void lock(){
        Thread t = Thread.currentThread();
        // 如果锁属于当前线程，则增加重入次数。
        if (t == owner.get()){
            count++;
            return;
        }
        // 否则代表有其他线程B想获得该锁，则一直自旋，直至线程B获取该锁。
        while (!owner.compareAndSet(null, t)){
            System.out.println(Thread.currentThread().getName() + " 正在自旋");
        }
    }

    public void unlock(){
        Thread t = Thread.currentThread();
        if (t == owner.get()){
            if (count > 0){
                count--;
            } else {
                owner.set(null);
            }
        }
    }

    public static void main(String[] args) {
        ReentrantSpinLock spinLock = new ReentrantSpinLock();
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " 开始尝试获取自旋锁");
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获取到了自旋锁");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放了自旋锁");
            }
        };

        new Thread(r, "Thread1").start();
        new Thread(r, "Thread2").start();
    }
}
