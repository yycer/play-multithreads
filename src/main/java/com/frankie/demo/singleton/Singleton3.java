package com.frankie.demo.singleton;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:35
 */
public class Singleton3 {

    /**
     * 懒汉式 - 非线程安全
     */
    private static Singleton3 singleton3;


    public static Singleton3 getInstance(){
        if (singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
