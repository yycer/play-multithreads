package com.frankie.demo.chapter10;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 21:57
 */
public class MyBQUsingCondition {

    private ArrayDeque<Object> queue;
    private int maxCapacity = 1 << 4;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition nonEmpty = reentrantLock.newCondition();
    private Condition nonFull  = reentrantLock.newCondition();

    public MyBQUsingCondition(int maxCapacity) {
        this.queue = new ArrayDeque<>();
        this.maxCapacity = maxCapacity;
    }

    public void put(Object o){
        reentrantLock.lock();
        try {
            while (queue.size() == maxCapacity){
                nonFull.await();
            }
            queue.offer(o);
            System.out.println(LocalDateTime.now() + " 生产者制造一件物品。");
            nonEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public Object take(){
        reentrantLock.lock();
        try {
            while (queue.size() == 0){
                nonEmpty.await();
            }
            nonFull.signalAll();
            System.out.println(LocalDateTime.now() + " 消费者拿走一件物品。");
            return queue.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return null;
    }
}
