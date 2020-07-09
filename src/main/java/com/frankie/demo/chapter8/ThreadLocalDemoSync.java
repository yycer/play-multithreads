package com.frankie.demo.chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 10:20
 */
public class ThreadLocalDemoSync {

    // 1000个线程分别对应1个SimpleDateFormat对象
    // 并且对sdf加锁
    private static ExecutorService service = Executors.newFixedThreadPool(16);
    private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        String ans;
        synchronized (sdf){
            ans = sdf.format(date);
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++){
            int cur = i;
            service.submit(() -> {
                ThreadLocalDemoSync demo1 = new ThreadLocalDemoSync();
                String date = demo1.date(cur);
                System.out.println(date);
            });
        }
        service.shutdown();
    }
}
