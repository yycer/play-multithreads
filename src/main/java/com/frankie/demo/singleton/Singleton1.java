package com.frankie.demo.singleton;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:35
 */
public class Singleton1 {

    /**
     * 简单饿汉式
     * 缺点: 类加载的时候就完成了实例化，而没有达到懒加载的效果。
     * 如果自始至终都没使用过这个实例，就会造成内存的浪费。
     */
    private static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getInstance(){
        return singleton1;
    }
}
