package com.frankie.demo.chapter5;

import java.util.HashMap;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 09:58
 */
public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<HashMapDemo, Integer> map = new HashMap<>(1);
        for (int i = 0; i < 10000; i++){
            map.put(new HashMapDemo(), 1);
        }
        System.out.println("Done");
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
