package com.frankie.demo.chapter2;

/**
 * @author: Yao Frankie
 * @date: 2020/7/5 19:18
 */
public class WrongResult {

    private static int ans = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                ans++;
            }
        };

        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ans);
    }
}
