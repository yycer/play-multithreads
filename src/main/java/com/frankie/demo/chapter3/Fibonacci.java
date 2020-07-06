package com.frankie.demo.chapter3;

import java.util.concurrent.RecursiveTask;

/**
 * @author: Yao Frankie
 * @date: 2020/7/6 10:42
 */
public class Fibonacci extends RecursiveTask<Integer> {

    int n;

    public Fibonacci(int n){
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1){
            return n;
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        f2.fork();
        return f1.join() + f2.join();
    }
}
