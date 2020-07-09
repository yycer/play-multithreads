package com.frankie.demo.chapter9;

import java.util.concurrent.*;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 15:03
 */
public class IsDoneTest {

    public static void main(String[] args) {

        Callable<IllegalArgumentException> ctask = () -> {
            throw new IllegalArgumentException("Callable 抛出异常");
        };

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<IllegalArgumentException> future = service.submit(ctask);
        try {
            for (int i = 0; i < 5; i++){
                System.out.println(i);
                Thread.sleep(100);
            }
            System.out.println("Callable task is done: " + future.isDone());
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
