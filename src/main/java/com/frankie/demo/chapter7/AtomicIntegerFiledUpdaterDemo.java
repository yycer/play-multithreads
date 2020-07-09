package com.frankie.demo.chapter7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 18:48
 */
public class AtomicIntegerFiledUpdaterDemo implements Runnable{

    static AtomicIntegerFieldUpdater<Score> scoreUpdater = AtomicIntegerFieldUpdater
            .newUpdater(Score.class, "score");

    static Score math;
    static Score computer;


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            computer.score++;
            scoreUpdater.getAndIncrement(math);
        }
    }

    public static class Score{
        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        math     = new Score();
        computer = new Score();
        AtomicIntegerFiledUpdaterDemo task = new AtomicIntegerFiledUpdaterDemo();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通变量的结果:   " + computer.score);
        System.out.println("升级后变量的结果: " + math.score);
//        普通变量的结果:   1994
//        升级后变量的结果: 2000
    }
}
