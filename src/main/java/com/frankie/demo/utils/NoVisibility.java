package com.frankie.demo.utils;

/**
 * @author: Yao Frankie
 * @date: 2020/1/5 15:19
 */
public class NoVisibility {
    private static boolean ready;
    private static int     number;

    public static class ReaderThread extends Thread{
        @Override
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println("Number = " + number);
        }
    }

    public static void start(){
        new ReaderThread().start();
        number = 10;
        ready  = true;
    }
}
