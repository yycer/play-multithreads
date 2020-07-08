package com.frankie.demo.chapter4;

/**
 * @author: Yao Frankie
 * @date: 2020/7/7 14:44
 */
public class CoarsenLockDemo {

    public void coarsenLock(){

        synchronized (this){
            // Do something.
        }

        synchronized (this){
            // Do something.
        }

        synchronized (this){
            // Do something.
        }
    }
}
