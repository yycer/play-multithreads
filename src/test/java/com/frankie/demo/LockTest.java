package com.frankie.demo;

import com.frankie.demo.lockUsage.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2019/12/28 21:01
 */
@SpringBootTest
public class LockTest {

    @Test
    public void reentrantLockTest(){
        ReentrantBeginning reentrantBeginning = new ReentrantBeginning();
        new Thread(() -> reentrantBeginning.printNum(), "threadA").start();
        new Thread(() -> reentrantBeginning.printNum(), "threadB").start();
        new Thread(() -> reentrantBeginning.printNum(), "threadC").start();
    }

    @Test
    public void reentrantSyncExecTest() throws InterruptedException {
        ReentrantSyncExec reentrantSyncExec = new ReentrantSyncExec();
        new Thread(() -> reentrantSyncExec.method1(), "threadA").start();
        new Thread(() -> reentrantSyncExec.method2(), "threadB").start();
        Thread.sleep(3100);

//        2020-01-13T10:49:10.482 method1() start in threadA
//        2020-01-13T10:49:12.482 method1() end   in threadA
//        2020-01-13T10:49:12.482 method2() start in threadB
//        2020-01-13T10:49:13.483 method2() end   in threadB
    }

    @Test
    public void reentrantConditionAwaitTest() throws InterruptedException {
        ReentrantUsage reentrantUsage = new ReentrantUsage();
        new Thread(() -> reentrantUsage.await()).start();
        Thread.sleep(1000);
    }

    @Test
    public void reentrantWaitNotifyUsingConditionTest() throws InterruptedException {
        ReentrantUsage reentrantUsage = new ReentrantUsage();
        new Thread(() -> reentrantUsage.awaitCorrectUsage(), "threadA").start();
        Thread.sleep(2000);
        new Thread(() -> reentrantUsage.signalCorrectUsage(), "threadB").start();
//        reentrantUsage.signalCorrectUsage();

//        2020-01-13T11:34:21.003 awaitCorrectUsage()  start in threadA
//        2020-01-13T11:34:22.999 signalCorrectUsage() start in threadB
    }

    @Test
    public void signalAllTest() throws InterruptedException {
        ReentrantUsage reentrantUsage = new ReentrantUsage();
        new Thread(() -> reentrantUsage.awaitA(), "threadA").start();
        new Thread(() -> reentrantUsage.awaitB(), "threadB").start();
        Thread.sleep(3000);
        reentrantUsage.signalAll();

//        2020-01-13T11:43:06.646 awaitA() method start in threadA
//        2020-01-13T11:43:06.647 awaitB() method end.  in threadB
//        2020-01-13T11:43:09.642 signalAll() method end.  in main
//        2020-01-13T11:43:09.642 signalAll() method end.  in main
//        2020-01-13T11:43:09.642 awaitA() method end.  in threadA
//        2020-01-13T11:43:09.642 awaitB() method end.  in threadB

    }

    @Test
    public void twoConditionTest() throws InterruptedException {
        TwoCondition twoCondition = new TwoCondition();
        new Thread(() -> twoCondition.awaitA(), "threadA").start();
        new Thread(() -> twoCondition.awaitB(), "threadB").start();
        Thread.sleep(2000);
        twoCondition.signalA();

//        2020-01-13T13:12:59.136 awaitA()  start in threadA
//        2020-01-13T13:12:59.136 awaitB()  start in threadB
//        2020-01-13T13:13:01.132 signalA() start in main
//        2020-01-13T13:13:01.132 signalA() end   in main
//        2020-01-13T13:13:01.132 awaitA()  end   in threadA
    }

    @Test
    public void printAlternativelyUsingWaitAndNotifyTest() throws InterruptedException {
        PrintAlternatively printAlternatively = new PrintAlternatively();
        new Thread(() -> printAlternatively.printOddNumberUsingWaitAndNotify(),  "threadA").start();
        new Thread(() -> printAlternatively.printEvenNumberUsingWaitAndNotify(), "threadB").start();

        Thread.sleep(100);
    }

    @Test
    public void printAlternativelyUsingAwaitAndSignalTest(){
        PrintAlternatively printAlternatively = new PrintAlternatively();
        new Thread(() -> printAlternatively.printOddNumberUsingCondition(),  "threadA").start();
        new Thread(() -> printAlternatively.printEvenNumberUsingCondition(), "threadB").start();
    }

    @Test
    public void fairnessLockTest() throws InterruptedException {
        /**
         * Fairness lock.
         */
//        FairnessLock fairnessLock1 = new FairnessLock();
//        fairnessLock1.setFairness(true);
//        Thread threadA = new Thread(() -> fairnessLock1.run(), "threadA");
//        Thread threadB = new Thread(() -> fairnessLock1.run(), "threadB");
//        Thread threadC = new Thread(() -> fairnessLock1.run(), "threadC");
//
//        threadA.start();
//        threadB.start();
//        threadC.start();
//
//        threadA.join();
//        threadB.join();
//        threadC.join();


        /**
         * Unfairness lock.
         */
        FairnessLock fairnessLock2 = new FairnessLock();
        fairnessLock2.setFairness(false);
        Thread threadA = new Thread(() -> fairnessLock2.run(), "threadA");
        Thread threadB = new Thread(() -> fairnessLock2.run(), "threadB");
        Thread threadC = new Thread(() -> fairnessLock2.run(), "threadC");

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
    }

    @Test
    public void remainderTest(){
        double random = Math.random();

        for(int i = 0; i < 20; i++){
            int j = (int) Math.random() * 1000;
            System.out.println(j);
        }
    }

    @Test
    public void lockTest() throws InterruptedException {
        PlayLock playLock = new PlayLock();
        Thread thread = new Thread(() -> playLock.doLock());
//        Thread thread = new Thread(() -> playLock.doLockInterruptibly(), "threadA");
        thread.start();
//        Thread.sleep(10);
        thread.interrupt();
        Thread.sleep(4000);
    }

    @Test
    public void executeTimeTest(){

        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            for(int j = 0; j < 100000; j++){
                Object o = new Object();
            }
        }
        long end = System.currentTimeMillis();
        long gap = end - start;
        System.out.println(gap); // 3406
    }

    @Test
    public void tryLockTest(){
        PlayLock playLock = new PlayLock();
        new Thread(() -> playLock.doTryLock(), "threadA").start();
        new Thread(() -> playLock.doTryLock(), "threadB").start();
    }

    @Test
    public void getHoldCountTest(){
        PlayLock playLock = new PlayLock();
        new Thread(() -> playLock.holdLockMethod1()).start();
    }

    @Test
    public void getQueueLengthTest() throws InterruptedException {
        PlayLock playLock = new PlayLock();
        new Thread(() -> playLock.doGetQueueLength(), "threadA").start();
        Thread.sleep(20);
        new Thread(() -> playLock.doGetQueueLength(), "threadB").start();
        new Thread(() -> playLock.doGetQueueLength(), "threadC").start();
        System.out.println("getQueueLength = " + playLock.lock.getQueueLength());
        Thread.sleep(2000);
    }

    @Test
    public void getWaitingQueueLengthTest() throws InterruptedException {
        PlayLock playLock = new PlayLock();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadA").start();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadB").start();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadC").start();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadD").start();
        Thread.sleep(100);
        playLock.printWaitQueueLength();
    }

    @Test
    public void hasQueuedThreadTest() throws InterruptedException {
        PlayLock playLock = new PlayLock();
        Thread threadA = new Thread(() -> playLock.doHasQueuedThread(), "threadA");
        threadA.start();
        Thread.sleep(10);
        Thread threadB = new Thread(() -> playLock.doHasQueuedThread(), "threadB");
        threadB.start();
        Thread.sleep(10);
        System.out.println("threadA is waiting to acquire lock? " + playLock.lock.hasQueuedThread(threadA));
        System.out.println("threadB is waiting to acquire lock? " + playLock.lock.hasQueuedThread(threadB));
        System.out.println("Has any threads waiting to acquire lock? " + playLock.lock.hasQueuedThreads());
    }

    @Test
    public void hasWaitersTest() throws InterruptedException {
        PlayLock playLock = new PlayLock();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadA").start();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadB").start();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadC").start();
        new Thread(() -> playLock.doGetWaitQueueLength(), "threadD").start();
        Thread.sleep(100);
        playLock.doHasWaiters();
    }

    @Test
    public void isFairTest(){
        PlayLock playLock = new PlayLock();
        new Thread(() -> playLock.doIsFair(), "threadA").start();
    }

    @Test
    public void isHeldByCurrentThreadTest() throws InterruptedException {
        PlayLock playLock = new PlayLock();
        new Thread(() -> playLock.doIsHeldByCurrentThread(), "threadA").start();
        Thread.sleep(10);
        System.out.println("lock is held by main thread? "+ playLock.lock.isHeldByCurrentThread());
        Thread.sleep(10);
    }
}






