package com.frankie.demo.chapter9;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 16:42
 */
public class TourismUsingCompletableTask {

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        TourismUsingCompletableTask tourism = new TourismUsingCompletableTask();
        Set<Integer> prices = tourism.getPrices();
        System.out.println(prices);
        long e = System.currentTimeMillis();
        System.out.println("Cost " + (e - s) + "ms");
    }

    private Set<Integer> getPrices() {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task("Shanghai", prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task("Shanghai", prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task("Shanghai", prices));
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        try {
            allTasks.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return prices;
    }

    private class Task implements Runnable{

        private String dest;
        private Set<Integer> prices;

        private Task(String dest, Set<Integer> prices) {
            this.dest   = dest;
            this.prices = prices;
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
        }
    }
}
