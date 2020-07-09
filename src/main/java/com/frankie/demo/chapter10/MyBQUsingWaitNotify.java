package com.frankie.demo.chapter10;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 22:11
 */
public class MyBQUsingWaitNotify {

    private int maxCapacity;
    private ArrayDeque<Object> queue;

    public MyBQUsingWaitNotify(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.queue = new ArrayDeque<>();
    }

    public void put(Object o){
        synchronized (this){
            while (queue.size() == maxCapacity){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(o);
            System.out.println(LocalDateTime.now() + " 生产者制造一件物品。");
            this.notifyAll();
        }
    }

    public Object take(){
        synchronized (this){
            while (queue.size() == 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object ret = queue.poll();
            System.out.println(LocalDateTime.now() + " 消费者拿走一件物品。");
            this.notifyAll();
            return ret;
        }
    }
}
