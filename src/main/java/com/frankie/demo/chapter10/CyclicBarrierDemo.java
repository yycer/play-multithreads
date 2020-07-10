package com.frankie.demo.chapter10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 20:20
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
                () -> System.out.println("-----凑齐三人，出发！-----"));
        for (int i = 0; i < 6; i++){
            new Thread(new Task(i + 1, cyclicBarrier)).start();
        }
    }

    public static class Task implements Runnable{

        private int id;
        private CyclicBarrier cyclicBarrier;

        public Task(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("同学" + id + " 现在从大门出发，前往自行车驿站。");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("同学" + id + " 到达自行车驿站，等待组队。");
                cyclicBarrier.await();
                System.out.println("同学" + id + " 开始骑车。");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
