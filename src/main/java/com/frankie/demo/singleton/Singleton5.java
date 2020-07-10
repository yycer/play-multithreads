package com.frankie.demo.singleton;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:35
 */
public class Singleton5 {

    /**
     * 懒汉式 - 线程安全[减小monitor锁粒度]
     * 缺点: 仍存在线程安全问题，两个线程同时执行17行的if语句块。
     */
    private static Singleton5 singleton5;

    public static Singleton5 getInstance(){
        if (singleton5 == null){
            synchronized (Singleton5.class){
                singleton5 = new Singleton5();
            }
        }
        return singleton5;
    }
}
