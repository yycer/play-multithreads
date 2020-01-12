package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 21:31
 */
public class ReentrantService {

    synchronized public void reentrantParentMethod(){
        System.out.println(LocalDateTime.now() + " reentrantParentMethod() start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " reentrantParentMethod() end");
    }

    synchronized public void method1(){
        System.out.println(LocalDateTime.now() + "Method1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method2();
        System.out.println(LocalDateTime.now() + "Method1 end");
    }

    synchronized private void method2() {
        System.out.println(LocalDateTime.now() + "Method2 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method3();
        System.out.println(LocalDateTime.now() + "Method2 end");
    }

    synchronized private void method3() {
        System.out.println(LocalDateTime.now() + "Method3 start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + "Method3 end");
    }

    synchronized public void parentSyncMethod(){
        System.out.println(LocalDateTime.now() + " parentSyncMethod() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " parentSyncMethod() end in " + Thread.currentThread().getName());
    }
}
