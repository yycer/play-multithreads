package com.frankie.demo.chapter9;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 16:24
 */
public class TourismUsingThreadPool {

    private ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        long s = System.currentTimeMillis();
        TourismUsingThreadPool demo1 = new TourismUsingThreadPool();
        Set<Integer> prices = demo1.getPrices();
        System.out.println(prices);
        long e = System.currentTimeMillis();
        System.out.println("Cost " + (e - s) + "ms");
    }

    private Set<Integer> getPrices() throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        service.submit(new Task("Shanghai", prices));
        service.submit(new Task("Shanghai", prices));
        service.submit(new Task("Shanghai", prices));
        Thread.sleep(3000);
        service.shutdown();
        return prices;
    }
    private class Task implements Runnable{

        private String destination;
        private Set<Integer> prices;

        private Task(String destination, Set<Integer> prices) {
            this.destination = destination;
            this.prices = prices;
        }

        @Override
        public void run() {
            int price = 0;
            try {
                Thread.sleep((long) (Math.random() * 4000));
                price = (int) (Math.random() * 4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prices.add(price);
        }
    }
}
