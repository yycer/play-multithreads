package com.frankie.demo.chapter2;

/**
 * @author: Yao Frankie
 * @date: 2020/7/5 19:32
 */
public class MayDeadLock {

    private Object o1;
    private Object o2;

    private void thread1() throws InterruptedException {
        synchronized (o1){
            Thread.sleep(500);
            synchronized (o2){
                System.out.println("线程1成功拿到两把锁");
            }
        }
    }

    private void thread2() throws InterruptedException {
        synchronized (o2){
            Thread.sleep(500);
            synchronized (o1){
                System.out.println("线程2成功拿到两把锁");
            }
        }
    }

    public static void main(String[] args) {
        MayDeadLock mayDeadLock = new MayDeadLock();
        new Thread(() -> {
            try {
                mayDeadLock.thread1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                mayDeadLock.thread2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
