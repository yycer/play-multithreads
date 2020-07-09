package com.frankie.demo.chapter7;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 19:38
 */
public class LongAdderDemo {

    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        long s = System.currentTimeMillis();
        ThreadPoolExecutor service = new ThreadPoolExecutor(
                16, 1000, 10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10000000; i++){
            service.submit(new LongAdderDemo.Task(counter));
        }
        long e = System.currentTimeMillis();
        // Cost : 5940ms
        System.out.println("Cost : " + (e - s) + "ms");
        service.shutdown();
    }

    public static class Task implements Runnable{

        private final LongAdder counter;

        public Task(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }
}
