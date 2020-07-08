package com.frankie.demo.chapter4;

/**
 * @author: Yao Frankie
 * @date: 2020/7/7 08:30
 */
public class SynTest {

    public void synBlock(){
        synchronized (this){
            System.out.println("yyc");
        }
    }

    public synchronized void synMethod(){

    }
}
