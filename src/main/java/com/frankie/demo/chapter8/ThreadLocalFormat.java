package com.frankie.demo.chapter8;

import java.text.SimpleDateFormat;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 13:42
 */
public class ThreadLocalFormat {
    public static ThreadLocal<SimpleDateFormat> tlFormat = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("mm:ss"));
}
