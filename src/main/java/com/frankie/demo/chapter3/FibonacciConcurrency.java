package com.frankie.demo.chapter3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author: Yao Frankie
 * @date: 2020/7/6 10:44
 */
public class FibonacciConcurrency {

    // 0 1 1 2 3 5 8
    // 0 1 2 3 4 5 6

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long lo = System.currentTimeMillis();
        // Method1
        ForkJoinPool fjp = new ForkJoinPool();
        for (int i = 0; i < 40; i++){
            ForkJoinTask<Integer> task = fjp.submit(new Fibonacci(i));
            System.out.println(task.get());
        }

        // Method2
//        int n = 40;
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++){
//            dp[i] = dp[i - 1] + dp[i - 2];
//            System.out.println(dp[i]);
//        }

        long hi = System.currentTimeMillis();
        // forkJoinPool: 12607
        // main thread : 1
        System.out.println(hi - lo);
    }
}
