package com.frankie.demo.chapter5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 11:16
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});
        System.out.println(list); // [1, 2, 3]

        Iterator<Integer> itr1 = list.iterator();

        list.add(4);
        System.out.println(list); // [1, 2, 3, 4]

        Iterator<Integer> itr2 = list.iterator();

        System.out.println("Verify Iterator1 content");
        itr1.forEachRemaining(System.out::println);

        System.out.println("Verify Iterator2 content");
        itr2.forEachRemaining(System.out::println);

//        Verify Iterator1 content
//        1
//        2
//        3
//        Verify Iterator2 content
//        1
//        2
//        3
//        4
    }
}
