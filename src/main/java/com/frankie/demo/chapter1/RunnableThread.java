package com.frankie.demo.chapter1;

/**
 * @author: Yao Frankie
 * @date: 2020/7/4 18:44
 */
public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("实现Runnable接口创建线程。");
    }
}
