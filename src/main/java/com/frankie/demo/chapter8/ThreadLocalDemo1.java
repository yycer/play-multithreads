package com.frankie.demo.chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 10:20
 */
public class ThreadLocalDemo1 {

    // 1000个线程分别对应1000个SimpleDateFormat对象
    private static ExecutorService service = Executors.newFixedThreadPool(16);

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++){
            int cur = i;
            service.submit(() -> {
                ThreadLocalDemo1 demo1 = new ThreadLocalDemo1();
                String date = demo1.date(cur);
                System.out.println(date);
            });
        }
        service.shutdown();
    }
}
