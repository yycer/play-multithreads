package com.frankie.demo.chapter9;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 16:02
 */
public class FutureFastSlowDemo {

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());
        Callable<String> fastTask = () -> "速度快的任务";

        Callable<String> slowTask = () -> {
            Thread.sleep(3000);
            return "速度慢的任务";
        };

        ExecutorService service = Executors.newFixedThreadPool(16);
        List<Future<String>> futures = new LinkedList<>();
        for (int i = 0; i < 4; i++){
            Future<String> future;
            if (i == 0 || i == 1){
                future = service.submit(slowTask);
            } else {
                future = service.submit(fastTask);
            }
            futures.add(future);
        }

        for (int i = 0; i < 4; i++){
            Future<String> future = futures.get(i);
            try {
                String ans = future.get(1, TimeUnit.SECONDS);
                System.out.println(LocalDateTime.now() + " " + ans);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
