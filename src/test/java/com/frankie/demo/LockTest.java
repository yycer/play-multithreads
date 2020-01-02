package com.frankie.demo;

import com.frankie.demo.lock.CountTask;
import com.frankie.demo.lock.TwinLock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author: Yao Frankie
 * @date: 2019/12/28 21:01
 */
@SpringBootTest
public class LockTest {

    @Test
    public void twinLockTest() throws InterruptedException {
        final TwinLock twinLock = new TwinLock();
        class Worker extends Thread {
            public void run(){
                while (true){
                    twinLock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(LocalDateTime.now() + " Thread name is " + Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        twinLock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        for (int i = 0; i < 10; i++){
            Thread.sleep(2000);
            System.out.println();
        }

        Thread.sleep(11000);
    }

    @Test
    public void forkJoinTest(){

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 10);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        try {
            System.out.println("Result = " + submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
