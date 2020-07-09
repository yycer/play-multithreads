package com.frankie.demo.chapter10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 19:14
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {

        Callable<Integer> task = () -> {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " 拿到了许可证，花费2秒执行慢服务");
            Thread.sleep(2000);
            System.out.println("慢服务执行完毕，" + Thread.currentThread().getName() + " 释放许可证");
            semaphore.release();
            return -1;
        };

        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 6; i++){
            service.submit(task);
        }
        service.shutdown();
    }
}
