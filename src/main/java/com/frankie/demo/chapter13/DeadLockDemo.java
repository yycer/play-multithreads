package com.frankie.demo.chapter13;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 14:52
 */
public class DeadLockDemo {

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "获取o1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "获取o2");
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "获取o2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "获取o1");
                }
            }
        };

        Thread t1 = new Thread(task1, "Thread1");
        Thread t2 = new Thread(task2, "Thread2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
