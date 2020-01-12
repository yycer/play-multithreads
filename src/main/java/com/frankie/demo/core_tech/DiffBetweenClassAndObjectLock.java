package com.frankie.demo.core_tech;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2020/1/9 22:06
 */
public class DiffBetweenClassAndObjectLock {

    /**
     * sync methods.
     */
    synchronized public void method1(){
        System.out.println(LocalDateTime.now() + " method1() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " method1() end   in " + Thread.currentThread().getName());
    }

    synchronized public void method2(){
        System.out.println(LocalDateTime.now() + " method2() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " method2() end   in " + Thread.currentThread().getName());
    }

    /**
     * sync static methods.
     */
    synchronized public static void staticMethod1(){
        System.out.println(LocalDateTime.now() + " staticMethod1() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " staticMethod1() end   in " + Thread.currentThread().getName());
    }

    synchronized public static void staticMethod2(){
        System.out.println(LocalDateTime.now() + " staticMethod2() start in " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " staticMethod2() end   in " + Thread.currentThread().getName());
    }

    /**
     * sync static blocks.
     */
    public void staticBlockMethod1(){
        synchronized (DiffBetweenClassAndObjectLock.class){
            System.out.println(LocalDateTime.now() + " staticBlockMethod1() start in " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " staticBlockMethod1() end   in " + Thread.currentThread().getName());
        }
    }

    public void staticBlockMethod2(){
        synchronized (DiffBetweenClassAndObjectLock.class){
            System.out.println(LocalDateTime.now() + " staticBlockMethod2() start in " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " staticBlockMethod2() end   in " + Thread.currentThread().getName());
        }
    }
}
