package com.frankie.demo;

import com.frankie.demo.lockUsage.PlayReentrantReadWriteLock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/1/20 10:47
 */
@SpringBootTest
public class ReentrantReadWriteLockTest {

    @Test
    public void readReadTest(){
        PlayReentrantReadWriteLock rrwLock = new PlayReentrantReadWriteLock();
        new Thread(() -> rrwLock.read(), "threadA").start();
        new Thread(() -> rrwLock.read(), "threadB").start();

//        2020-01-20T10:51:29.877 [threadB] enter read()
//        2020-01-20T10:51:29.877 [threadA] enter read()
    }

    @Test
    public void readWriteTest() throws InterruptedException {
        PlayReentrantReadWriteLock rrwLock = new PlayReentrantReadWriteLock();
        new Thread(() -> rrwLock.read(), "threadA").start();
        new Thread(() -> rrwLock.write(), "threadB").start();
        Thread.sleep(3100);

//        2020-01-20T10:51:02.387 [threadA] enter read()
//        2020-01-20T10:51:05.388 [threadB] enter write()
    }

    @Test
    public void writeReadTest() throws InterruptedException {
        PlayReentrantReadWriteLock rrwLock = new PlayReentrantReadWriteLock();
        new Thread(() -> rrwLock.write(), "threadA").start();
        new Thread(() -> rrwLock.read(), "threadB").start();
        Thread.sleep(3100);

//        2020-01-20T10:52:16.997 [threadA] enter write()
//        2020-01-20T10:52:19.997 [threadB] enter read()
    }

    @Test
    public void writeWriteTest() throws InterruptedException {
        PlayReentrantReadWriteLock rrwLock = new PlayReentrantReadWriteLock();
        new Thread(() -> rrwLock.write(), "threadA").start();
        new Thread(() -> rrwLock.write(), "threadB").start();
        Thread.sleep(3100);

//        2020-01-20T10:52:59.941 [threadA] enter write()
//        2020-01-20T10:53:02.943 [threadB] enter write()
    }
}
