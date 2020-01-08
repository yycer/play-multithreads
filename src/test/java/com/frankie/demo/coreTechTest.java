package com.frankie.demo;

import com.frankie.demo.core_tech.ExceptionReleaseLock;
import com.frankie.demo.core_tech.HashSelfPrivateNum;
import com.frankie.demo.core_tech.PublicVariable;
import com.frankie.demo.core_tech.ReentrantChildService;
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
}
