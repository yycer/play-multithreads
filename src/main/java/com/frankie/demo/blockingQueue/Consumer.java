package com.frankie.demo.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author: Yao Frankie
 * @date: 2020/1/3 20:49
 */
public class Consumer implements Runnable{

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
