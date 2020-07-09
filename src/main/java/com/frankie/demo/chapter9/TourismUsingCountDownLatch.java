package com.frankie.demo.chapter9;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 16:36
 */
public class TourismUsingCountDownLatch {

    private ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        long s = System.currentTimeMillis();
        TourismUsingCountDownLatch tourism = new TourismUsingCountDownLatch();
        Set<Integer> prices = tourism.getPrices();
        System.out.println(prices);
        long e = System.currentTimeMillis();
        System.out.println("Cost " + (e - s) + "ms");
    }

    private Set<Integer> getPrices() throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        CountDownLatch latch = new CountDownLatch(3);
        service.submit(new Task("Shanghai", prices, latch));
        service.submit(new Task("Shanghai", prices, latch));
        service.submit(new Task("Shanghai", prices, latch));
        latch.await(3, TimeUnit.SECONDS);
        service.shutdown();
        return prices;
    }
    private class Task implements Runnable{

        private String dest;
        private Set<Integer> prices;
        private CountDownLatch latch;

        private Task(String dest, Set<Integer> prices, CountDownLatch latch) {
            this.dest   = dest;
            this.prices = prices;
            this.latch  = latch;
        }

        @Override
        public void run() {
            int price = 0;
            try {
                Thread.sleep((long) (Math.random() * 400));
                price = (int) (Math.random() * 400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prices.add(price);
            latch.countDown();
        }
    }
}
