package com.frankie.demo.chapter13;

import java.util.Arrays;

/**
 * @author: Yao Frankie
 * @date: 2020/7/10 16:18
 */
public class FinalDemo {

    public static void main(String[] args) {

        final int[] arr = new int[5];
        Arrays.fill(arr, 1);
        for (int i = 0; i < 5; i++){
            arr[i] *= 10;
        }
        System.out.println(Arrays.toString(arr));
    }
}
