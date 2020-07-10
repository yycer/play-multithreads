package com.frankie.demo.singleton;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:35
 */
public class Singleton4 {

    /**
     * 懒汉式 - 线程安全[synchronized加在方法上]
     */
    private static Singleton4 singleton4;

    public static synchronized Singleton4 getInstance(){
        if (singleton4 == null){
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}
