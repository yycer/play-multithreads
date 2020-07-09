package com.frankie.demo.chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.SimpleFormatter;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 10:20
 */
public class ThreadLocalDemo4 {

    // 1000个任务对应16个线程，每个线程都有独有的SimpleDateFormat对象。
    private static ExecutorService service = Executors.newFixedThreadPool(16);

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
//        SimpleDateFormat dateFormat = new ThreadLocalFormat().tlFormat.get();
        SimpleDateFormat dateFormat = ThreadLocalFormat.tlFormat.get();
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            int cur = i;
            service.submit(() -> {
                ThreadLocalDemo4 demo1 = new ThreadLocalDemo4();
                String date = demo1.date(cur);
                System.out.println(date);
            });
        }
        service.shutdown();
    }

}
