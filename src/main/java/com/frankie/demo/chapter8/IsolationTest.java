package com.frankie.demo.chapter8;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 14:26
 */
public class IsolationTest {

    public static void main(String[] args) {

        Runnable t1 = () -> {
            for (int i = 0; i < 1000; i++) {
                Tools.tl.set("ThreadA" + i);
                System.out.println(Tools.tl.get());
            }
        };

    }
}
