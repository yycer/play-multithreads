package com.frankie.demo.producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author: Yao Frankie
 * @date: 2020/1/3 15:21
 */
public class Producer implements Runnable{

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            Message message = new Message("" + i);
            try {
                Thread.sleep(i);
                queue.put(message);
                System.out.println("Producer " + message.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message exit = new Message("exit");
            try {
                queue.put(exit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
