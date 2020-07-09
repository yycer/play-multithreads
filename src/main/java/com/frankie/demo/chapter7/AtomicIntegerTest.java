package com.frankie.demo.chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 17:29
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(10);
        int oldValue = ai.getAndSet(20);
        System.out.println(oldValue);
        System.out.println(ai.get());
    }
}
