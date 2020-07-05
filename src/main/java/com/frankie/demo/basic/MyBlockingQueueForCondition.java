package com.frankie.demo.basic;

import com.sun.xml.internal.fastinfoset.algorithm.IEEE754FloatingPointEncodingAlgorithm;
import org.omg.CORBA.IRObject;

import javax.swing.plaf.PanelUI;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/7/5 15:34
 */
public class MyBlockingQueueForCondition {

    private ArrayDeque<Object> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull  = lock.newCondition();

    public MyBlockingQueueForCondition(int size){
        this.max = size;
        queue = new ArrayDeque<>();
    }

    public void put(Object o){
        lock.lock();
        try {
            while (queue.size() == max){
                notFull.await();
            }
            queue.offer(o);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object take(){
        lock.lock();
        try {
            while (queue.size() == 0){
                notEmpty.await();
            }
            Object item = queue.poll();
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
