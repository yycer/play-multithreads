package com.frankie.demo.core_tech;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 20:26
 */
public class HashSelfPrivateNum {

//    public volatile int num = 0;
    private int num = 0;

    public synchronized void addNum(String username) {
//        int num = 0;
//        synchronized (this){
            if ("a".equals(username)){
                num = 10;
                System.out.println("a set over.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                num = 20;
                System.out.println("b set over.");
            }
//        }
        System.out.println("username = " + username + ", num = " + num);
    }
}
