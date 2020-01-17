package com.frankie.demo.lockUsage;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/1/15 16:29
 */
public class PlayLock {

    public ReentrantLock lock = new ReentrantLock();

    public Condition condition1 = lock.newCondition();
    public Condition condition2 = lock.newCondition();

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

    public void holdLockMethod1(){
        try {
            lock.lock();
            System.out.println("Enter holdLockMethod1(), lock count = " + lock.getHoldCount());
            holdLockMethod2();
        } finally {
            lock.unlock();
        }
    }

    private void holdLockMethod2() {
        try {
            lock.lock();
            System.out.println("Enter holdLockMethod2(), lock count = " + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }

    public void doGetQueueLength(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " enter doGetQueueLength()");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void doGetWaitQueueLength(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " enter doGetWaitQueueLength()");
            System.out.println(Thread.currentThread().getName() + " hold count = " + lock.getHoldCount());
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printWaitQueueLength(){
        try {
            lock.lock();
            System.out.println("Wait queue length is " + lock.getWaitQueueLength(condition1));
            condition1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void doHasQueuedThread(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " enter doHasQueuedThread()");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void doHasWaiters(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +
                    " hasWaiter() = " + lock.hasWaiters(condition1));
            System.out.println(Thread.currentThread().getName() +
                    " getWaitQueueLength() = " + lock.getWaitQueueLength(condition1));
        } finally {
            lock.unlock();
        }
    }

    public void doIsFair(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +
                    " isFair = " + lock.isFair());
        } finally {
            lock.unlock();
        }
    }

    public void doIsHeldByCurrentThread(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +
                    " isHeldByCurrentThread = " + lock.isHeldByCurrentThread());
        } finally {
            lock.unlock();
        }

    }


    /**
     * Lock的使用
     */
    public void lockMethod1(){
        try {
            lock.lock();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] enter lockMethod1()");
            Thread.sleep(1000);
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] enter lockMethod1()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void lockMethod2(){
        try {
            lock.lock();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] enter lockMethod2()");
            Thread.sleep(2000);
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] enter lockMethod2()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 通知部分线程。
     */
    public void awaitCondition1(){
        try {
            lock.lock();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] enter awaitCondition1()");
            Thread.sleep(1000);
            condition1.await();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] exit  awaitCondition1()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitCondition2(){
        try {
            lock.lock();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] enter awaitCondition2()");
            Thread.sleep(1000);
            condition2.await();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] exit  awaitCondition2()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalCondition1(){
        try {
            lock.lock();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] enter signalCondition1()");
            condition1.signal();
            System.out.println(LocalDateTime.now() + " ["  + Thread.currentThread().getName() +
                    "] exit  signalCondition1()");
        } finally {
            lock.unlock();
        }
    }

}












