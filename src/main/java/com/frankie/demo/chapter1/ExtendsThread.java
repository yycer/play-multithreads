package com.frankie.demo.chapter1;

/**
 * @author: Yao Frankie
 * @date: 2020/7/4 18:46
 */
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("继承Thread类创建线程。");
    }
}
