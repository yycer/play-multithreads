package com.frankie.demo.chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 08:52
 */
public class HashMapNotSafe {

    public static void main(String[] args) {

        final Map<Integer, String> map = new HashMap<>();
        final Integer targetKey  = (1 << 16) - 1;
        final String targetValue = "Whatever";
        map.put(targetKey, targetValue);

        new Thread(() -> {
            IntStream.range(0, targetKey).forEach(k -> map.put(k, "value"));
        }).start();

        while (true){
            if (null == map.get(targetKey)){
                throw new RuntimeException("HashMap is not thread safe.");
            }
        }
    }
}
