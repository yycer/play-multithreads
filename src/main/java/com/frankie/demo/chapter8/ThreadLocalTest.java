package com.frankie.demo.chapter8;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 10:10
 */
public class ThreadLocalTest {

    public static ThreadLocal<String> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        if (null == tl.get()){
            System.out.println("t1中无值");
            tl.set("yyc");
        }
        System.out.println(tl.get());
        System.out.println(tl.get());
    }
}
