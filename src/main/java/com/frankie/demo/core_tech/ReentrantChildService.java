package com.frankie.demo.core_tech;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 21:34
 */
public class ReentrantChildService extends ReentrantService {

    synchronized public void reentrantChildMethod(){
        System.out.println("Call reentrantChildMethod()");
        this.reentrantParentMethod();
    }
}
