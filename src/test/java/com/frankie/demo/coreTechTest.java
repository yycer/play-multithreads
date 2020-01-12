package com.frankie.demo;

import com.frankie.demo.core_tech.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

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
    public void multiObjectMultiLockTest() throws InterruptedException {

//        new Thread(() -> new MultiObjectMultiLock().methodA(), "threadA").start();
//        new Thread(() -> new MultiObjectMultiLock().methodB(), "threadB").start();
//        Thread.sleep(3200);

        MultiObjectMultiLock lock = new MultiObjectMultiLock();
        new Thread(() -> lock.methodA(), "threadA").start();
        new Thread(() -> lock.methodB(), "threadB").start();
        Thread.sleep(3200);
    }

    @Test
    public void syncMethodHalfSyncHalfAsyncTest() throws InterruptedException {
        HalfAsyncHalfSync half = new HalfAsyncHalfSync();
        new Thread(() -> half.syncMethodA(), "threadA").start();
        new Thread(() -> half.methodB(), "threadB").start();
        Thread.sleep(3200);
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
    public void reentrantLockTest() throws InterruptedException {
        // Step1: Call internal nested synchronized methods.
//        new Thread(() -> new ReentrantService().method1()).start();
//        Thread.sleep(6100);

        // Step2: Child class calls synchronized method in parent class.
        new Thread(() -> new ReentrantChildService().reentrantChildMethod()).start();
        Thread.sleep(3100);
    }

    @Test
    public void exceptionReleaseLockTest() throws InterruptedException {
        System.out.println(LocalDateTime.now() + " exceptionReleaseLockTest() start.");
        ExceptionReleaseLock exceptionLock = new ExceptionReleaseLock();
        new Thread(() -> exceptionLock.releaseALock(), "threadA").start();
        Thread.sleep(10);
        new Thread(() -> exceptionLock.releaseALock(), "threadB").start();
        Thread.sleep(100);
    }

    @Test
    public void syncMethodDoesNotHaveInheritTest() throws InterruptedException {
        ReentrantChildService child = new ReentrantChildService();
        new Thread(() -> child.childMethod(), "threadA").start();
        new Thread(() -> child.childMethod(), "threadB").start();
        Thread.sleep(7100);
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

    @Test
    public void changeLockObjectTest() throws InterruptedException {
        LockObjectChange loc = new LockObjectChange();
        new Thread(() -> loc.justPrint(), "threadA").start();
        Thread.sleep(50);
        new Thread(() -> loc.justPrint(), "threadB").start();
        Thread.sleep(4100);

        /**
         * Without lock = "456";
         */
//        2020-01-10T21:27:25.811 current thread = threadA
//        2020-01-10T21:27:27.811 current thread = threadA
//        2020-01-10T21:27:27.811 current thread = threadB
//        2020-01-10T21:27:29.811 current thread = threadB


        /**
         * With lock = "456";
         */
//        2020-01-10T21:28:05.925 current thread = threadA
//        2020-01-10T21:28:05.972 current thread = threadB
//        2020-01-10T21:28:07.925 current thread = threadA
//        2020-01-10T21:28:07.973 current thread = threadB
    }

    @Test
    public void justChangePropertyTest() throws InterruptedException {
        JustChangeProperty jcp = new JustChangeProperty();
        Order order = new Order();
        order.setAmount("20");
        new Thread(() -> jcp.justChangeProperty(order), "threadA").start();
        order.setAmount("50");
        new Thread(() -> jcp.justChangeProperty(order), "threadB").start();
        Thread.sleep(5000);


//        2020-01-10T21:32:12.949 current thread = threadA
//        2020-01-10T21:32:14.949 current thread = threadA
//        2020-01-10T21:32:14.949 current thread = threadB
//        2020-01-10T21:32:16.951 current thread = threadB
    }

    @Test
    public void endlessLoopTest() throws InterruptedException {
//        EndlessLoop ell = new EndlessLoop();
//        ell.print();
//        ell.setContinuePrint(false);

//        2020-01-10T22:15:20.257 current thread = main
//        2020-01-10T22:15:21.257 current thread = main
//        2020-01-10T22:15:22.258 current thread = main
//        2020-01-10T22:15:23.258 current thread = main
//        2020-01-10T22:15:24.258 current thread = main
//        2020-01-10T22:15:25.258 current thread = main
//        2020-01-10T22:15:26.259 current thread = main
//        2020-01-10T22:15:27.259 current thread = main
//        ...

//         EndlessLoop ell = new EndlessLoop();
//         new Thread(() -> ell.print()).start();
//         Thread.sleep(2100);
//         ell.setContinuePrint(false);

//        2020-01-10T22:28:06.994 current thread = Thread-2
//        2020-01-10T22:28:07.994 current thread = Thread-2
//        2020-01-10T22:28:08.994 current thread = Thread-2

        EndlessLoop ell = new EndlessLoop();
        new Thread(() -> ell.print(), "threadA").start();
        Thread.sleep(2100);
        new Thread(() -> ell.setContinuePrint(false), "threadB").start();
    }
}












