package com.frankie.demo.singleton;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 10:35
 */
public enum Singleton8 {

    /**
     * 枚举类
     * 1. 保证线程安全
     * 2. 防止反序列化，反射创建新的对象。
     */
    INSTANCE;

}
