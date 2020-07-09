package com.frankie.demo.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 08:33
 */
public class AccumulatorDemo {

    public static void main(String[] args) throws InterruptedException {

//        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        LongAccumulator accumulator = new LongAccumulator(Long::sum, 0);
        ExecutorService service = Executors.newFixedThreadPool(8);
        IntStream.range(1, 10).forEach(i -> service.submit(() -> accumulator.accumulate(i)));
        Thread.sleep(100);
        System.out.println(accumulator.getThenReset());
    }
}
