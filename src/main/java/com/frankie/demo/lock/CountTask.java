package com.frankie.demo.lock;

import java.util.concurrent.RecursiveTask;

/**
 * @author: Yao Frankie
 * @date: 2019/12/29 12:09
 */
public class CountTask extends RecursiveTask<Integer> {

    // 阈值
    private static final int THREASHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end){
        this.start = start;
        this.end   = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        System.out.println("start = " + start + " , end = " + end);
        boolean canCompute = (end - start) <= THREASHOLD;
        if (canCompute){
            for (int i = start; i <= end; i++){
                System.out.println("sum = " + sum + ", i = " + i);
                sum += i;
            }
        } else {
            int mid = (start + end) / 2;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);

            leftTask.fork();
            rightTask.fork();

            int leftResult  = leftTask.join();
            int rightResult = rightTask.join();
            System.out.println("join sum = " + sum + ", leftResult = " + leftResult + ", rightResult = " + rightResult);
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
