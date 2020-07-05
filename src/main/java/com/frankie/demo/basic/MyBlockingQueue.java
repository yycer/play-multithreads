package com.frankie.demo.basic;

import java.util.ArrayDeque;

/**
 * @author: Yao Frankie
 * @date: 2020/7/5 15:38
 */
public class MyBlockingQueue {

    private int max;
    private ArrayDeque<Object> queue;

    public MyBlockingQueue(int size){
        this.max = size;
        queue = new ArrayDeque<>();
    }

    public synchronized void put() throws InterruptedException {
        while (queue.size() == max){
            wait();
        }
        queue.offer(new Object());
        notifyAll();
    }

    public synchronized void take() throws InterruptedException {
        while (queue.size() == 0){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " " + queue.poll());
        notifyAll();
    }
}
