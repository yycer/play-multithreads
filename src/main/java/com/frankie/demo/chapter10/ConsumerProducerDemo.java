package com.frankie.demo.chapter10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 21:55
 */
public class ConsumerProducerDemo {

    public static void main(String[] args) {
        conditionTest();
//        waitNotifyTest();
    }

    private static void waitNotifyTest() {

        MyBQUsingWaitNotify myBlockingQueue = new MyBQUsingWaitNotify(3);

        Callable<Integer> put = () -> {
            Thread.sleep((long) (Math.random() * 10));
            myBlockingQueue.put(new Object());
            return -1;
        };

        Callable<Integer> take = () -> {
            Thread.sleep((long) (Math.random() * 10000));
            myBlockingQueue.take();
            return -1;
        };

        ExecutorService service = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 20; i++){
            if ((i & 1) == 1){
                service.submit(put);
            } else {
                service.submit(take);
            }
        }
        service.shutdown();
    }

    private static void conditionTest() {

        MyBQUsingCondition myBlockingQueue = new MyBQUsingCondition(3);

        Callable<Integer> put = () -> {
            Thread.sleep((long) (Math.random() * 10000));
            myBlockingQueue.put(new Object());
            return -1;
        };

        Callable<Integer> take = () -> {
            Thread.sleep((long) (Math.random() * 100));
            myBlockingQueue.take();
            return -1;
        };

        ExecutorService service = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 20; i++){
            if ((i & 1) == 1){
                service.submit(put);
            } else {
                service.submit(take);
            }
        }
        service.shutdown();
    }
}
