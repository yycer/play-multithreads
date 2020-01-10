package com.frankie.demo.core_tech;

/**
 * @author: Yao Frankie
 * @date: 2020/1/10 20:38
 */
public class DeadLock {

    public Object o1 = new Object();
    public Object o2 = new Object();

    public void tryDeadLock(String username){
        if ("a".equals(username)){
            synchronized (o1){
                try {
                    System.out.println(
                            "current thread name " + Thread.currentThread().getName() +
                            ", a get o1");
                    Thread.sleep(10000);
                    synchronized (o2){
                        System.out.println(
                                "current thread name " + Thread.currentThread().getName() +
                                ", a get o2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            synchronized (o2){
                try {
                    System.out.println(
                            "current thread name " + Thread.currentThread().getName() +
                            ", b get o2");
                    Thread.sleep(15000);
                    synchronized (o1){
                        System.out.println(
                                "current thread name " + Thread.currentThread().getName() +
                                ", b get o1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
