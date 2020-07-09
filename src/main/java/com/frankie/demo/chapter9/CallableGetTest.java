package com.frankie.demo.chapter9;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 14:46
 */
public class CallableGetTest {

    public static void main(String[] args) {
        Callable<Integer> ctask = () -> {
            Thread.sleep(3000);
//            int a = 10 / 0; // ExecutionException
            return new Random().nextInt();
        };

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(ctask);
        try {
            service.shutdownNow(); // InterruptedException
            future.get(4, TimeUnit.SECONDS); // TimeoutException
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
