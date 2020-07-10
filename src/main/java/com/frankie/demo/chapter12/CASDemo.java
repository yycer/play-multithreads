package com.frankie.demo.chapter12;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 14:20
 */
public class CASDemo implements Runnable{

    private volatile int val;

    public synchronized int compareAndSwap(int expectedVal, int newVal){
        int oldVal = val;
        if (expectedVal == oldVal){
            val = newVal;
            System.out.println(Thread.currentThread().getName() + " 执行成功。");
        }
        return oldVal;
    }

    public static void main(String[] args) throws InterruptedException {

        CASDemo task = new CASDemo();
        task.val = 100;

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(task.val);
    }

    @Override
    public void run() {
        compareAndSwap(100, 150);
    }
}
