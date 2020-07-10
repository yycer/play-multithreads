package com.frankie.demo.singleton;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:35
 */
public class Singleton6 {

    /**
     * 双重检查模式
     */

    /**
     * 为什么要使用volatile关键字？
     * 防止重排序，避免拿到未完全初始化的对象。
     * -------------------------------------------------------------------------------------
     * 首先，在JVM中对于 singleton = new Singleton();这句语句最少包含以下三个操作：
     * 1. 给singleton分配内存空间。
     * 2. 调用Singleton的构造函数等来初始化singleton。
     * 3. 将singleton对象指向分配的内存空间。
     * 但是，可能存在重排序的优化，如：1-3-2
     * 假设线程A执行到第三步，此时singleton已经不是null，
     * 然后线程B也来获取实例并进行操作，但是此时singleton其实并没有完全初始化，所以可能会导致异常。
     * -------------------------------------------------------------------------------------
     */
    private static volatile Singleton6 singleton6;

    public static Singleton6 getInstance(){
        if (singleton6 == null){
            synchronized (Singleton6.class){
                if (singleton6 == null){
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}
