package com.frankie.demo.chapter1;

/**
 * @author: Yao Frankie
 * @date: 2020/7/4 19:15
 */
public class RunAndCreateDiff {

    static class MyRunnable implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start(); // Thread-0
        thread.run(); // main
    }
}
