package com.frankie.demo;

import com.frankie.demo.core_tech.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 20:28
 */
@SpringBootTest
public class coreTechTest {

    private int count = 1;

    @Test
    public void methodPrivateNumTest() throws InterruptedException {
        HashSelfPrivateNum numRef = new HashSelfPrivateNum();

        Thread threadA = new Thread(() -> numRef.addNum("a"));
        Thread threadB = new Thread(() -> numRef.addNum("b"));
        threadA.start();
        threadB.start();

        Thread.sleep(1500);
    }

    @Test
    public void accessInstanceVariableTest(){
        System.out.println("count = " + count);
    }

    @Test
    public void dirtyReadTest() throws InterruptedException {
        PublicVariable pv = new PublicVariable();
        new Thread(() -> pv.setValue("B", "BB"), "threadA").start();
        Thread.sleep(50);
        pv.getValue();
        Thread.sleep(200);
    }

    @Test
    public void reentrantLockTest(){
        // Step1: Call internal nested synchronized methods.
//        new Thread(() -> new ReentrantService().method1()).start();
//        Call method1
//        Call method2
//        Call method3

        // Step2: Child class calls synchronized method in parent class.
        new Thread(() -> new ReentrantChildService().reentrantChildMethod()).start();

    }

    @Test
    public void exceptionReleaseLockTest() throws InterruptedException {
        ExceptionReleaseLock exceptionLock = new ExceptionReleaseLock();
//        System.out.println(LocalDateTime.now());
        new Thread(() -> exceptionLock.releaseALock(), "threadA").start();
        Thread.sleep(50);
        new Thread(() -> exceptionLock.releaseALock(), "threadB").start();
        Thread.sleep(100);

//        Current thread name threadA run time 2020-01-08T21:51:10.815
//        Exception in thread "threadA" java.lang.NumberFormatException: For input string: "a"
//        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//        at java.lang.Integer.parseInt(Integer.java:580)
//        at java.lang.Integer.parseInt(Integer.java:615)
//        at com.frankie.demo.core_tech.ExceptionReleaseLock.releaseALock(ExceptionReleaseLock.java:18)
//        at com.frankie.demo.coreTechTest.lambda$exceptionReleaseLockTest$4(coreTechTest.java:61)
//        at java.lang.Thread.run(Thread.java:748)
//        Current thread name threadB run time 2020-01-08T21:51:10.862

    }

    @Test
    public void halfAsyncHalfSyncTest(){
        HalfAsyncHalfSync half = new HalfAsyncHalfSync();
        new Thread(() -> half.doLongTimeTask(), "threadA").start();
        new Thread(() -> half.doLongTimeTask(), "threadB").start();
    }

    @Test
    public void doubleSyncBlockOneObjectTest() throws InterruptedException {
        DoubleSyncBlockOneObject doubleSync = new DoubleSyncBlockOneObject();
        new Thread(() -> doubleSync.methodA(), "threadA").start();
        new Thread(() -> doubleSync.methodB(), "threadB").start();
        Thread.sleep(5000);

//        Start methodA at 2020-01-09T20:53:15.141
//        End   methodA at 2020-01-09T20:53:17.141
//        Start methodB at 2020-01-09T20:53:17.141
//        End   methodB at 2020-01-09T20:53:18.141
    }

    @Test
    public void syncStaticMethodTest() throws InterruptedException {
        new Thread(() -> SyncStaticMethod.methodA(), "threadA").start();
        new Thread(() -> SyncStaticMethod.methodB(), "threadB").start();
        Thread.sleep(5000);

//        Start methodA at 2020-01-09T22:01:33.439
//        End   methodA at 2020-01-09T22:01:35.440
//        Start methodB at 2020-01-09T22:01:35.440
//        End   methodB at 2020-01-09T22:01:36.440
    }

    @Test
    public void diffBetweenClassAndObjectLockTest() throws InterruptedException {
        DiffBetweenClassAndObjectLock diffLock = new DiffBetweenClassAndObjectLock();
        new Thread(() -> DiffBetweenClassAndObjectLock.staticMethodA(), "threadA").start();
        new Thread(() -> DiffBetweenClassAndObjectLock.staticMethodB(), "threadB").start();
        new Thread(() -> diffLock.methodC(), "threadC").start();
        Thread.sleep(3000);

//        Start static methodA at 2020-01-09T22:10:01.347
//        Start methodC at 2020-01-09T22:10:01.347
//        End   methodC at 2020-01-09T22:10:01.347
//        End   static methodA at 2020-01-09T22:10:03.347
//        Start static methodB at 2020-01-09T22:10:03.347
//        End   static methodB at 2020-01-09T22:10:03.347
    }

    @Test
    public void classLockAllObjectTest() throws InterruptedException {
        ClassLockAllObject classLock1 = new ClassLockAllObject();
        ClassLockAllObject classLock2 = new ClassLockAllObject();

        new Thread(() -> classLock1.methodA(), "threadA").start();
        new Thread(() -> classLock2.methodB(), "threadB").start();

        Thread.sleep(3100);

//        Start methodA at 2020-01-09T22:16:55.844
//        End   methodA at 2020-01-09T22:16:57.844
//        Start methodB at 2020-01-09T22:16:57.844
//        End   methodB at 2020-01-09T22:16:58.845

    }

    @Test
    public void deadLockTest() throws InterruptedException {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> deadLock.tryDeadLock("a"), "threadA").start();
        Thread.sleep(10);
        new Thread(() -> deadLock.tryDeadLock("b"), "threadB").start();
//        Thread.sleep(300);
    }
}












