package com.frankie.demo.singleton;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:35
 */
public class Singleton7 {

    /**
     * 静态内部类
     * JVM保证了线程安全，并做到了延迟加载。
     */
    private static class SingletonInstance{
        private static final Singleton7 singleton = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return SingletonInstance.singleton;
    }
}
