package com.frankie.demo.chapter1;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author: Yao Frankie
 * @date: 2020/7/4 18:52
 */
public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() {
        return new Random().nextInt();
    }
}
