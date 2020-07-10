package com.frankie.demo.chapter11;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:19
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        // 为什么要Double-Check?
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    // 以下操作并非原子操作。
                    // 如：分配空间、初始化、指向分配的内存空间。
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
