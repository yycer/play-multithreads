package com.frankie.demo.core_tech;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 21:31
 */
public class ReentrantService {

    synchronized public void reentrantParentMethod(){
        System.out.println("Call reentrantParentMethod()");
    }

    synchronized public void method1(){
        System.out.println("Call method1");
        method2();
    }

    synchronized private void method2() {
        System.out.println("Call method2");
        method3();
    }

    synchronized private void method3() {
        System.out.println("Call method3");
    }
}
