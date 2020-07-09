package com.frankie.demo.chapter7;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 19:32
 */
public class AtomicLongDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong counter = new AtomicLong(0);
        long s = System.currentTimeMillis();
        ThreadPoolExecutor service = new ThreadPoolExecutor(
                16, 1000, 10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10000000; i++){
            service.submit(new Task(counter));
        }
        long e = System.currentTimeMillis();
        // Cost : 7840ms, corePoolSize = 16, maximumPoolSize = 10000
        System.out.println("Cost : " + (e - s) + "ms");
        service.shutdown();
    }

    static class Task implements Runnable{

        private final AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.incrementAndGet();
        }
    }
}
