package com.frankie.demo.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author: Yao Frankie
 * @date: 2020/1/3 20:49
 */
public class Producer implements Runnable{

    private BlockingQueue queue;

    public Producer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
