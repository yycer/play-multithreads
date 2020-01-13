package com.frankie.demo.producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author: Yao Frankie
 * @date: 2020/1/3 15:24
 */
public class Consumer implements Runnable {

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        Message msg;
        try {
            while ((msg = queue.take()).getMessage() != "exit"){
                Thread.sleep(10);
                System.out.println("Consumer " + msg.getMessage());
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
