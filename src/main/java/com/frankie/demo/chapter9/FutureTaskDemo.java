package com.frankie.demo.chapter9;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 15:16
 */
public class FutureTaskDemo {

    public static void main(String[] args) {

        Callable<Integer> ctask = () -> {
            System.out.println("子线程正在计算");
            return IntStream.range(1, 10).reduce(0, (x, y) -> x + y);
        };

//        FutureTask<Integer> futureTask = new FutureTask<>(ctask);
//        new Thread(futureTask).start();

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(ctask);
        try {
            System.out.println("Task运行结果: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
