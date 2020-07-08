package com.frankie.demo.chapter6;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: Yao Frankie
 * @date: 2020/7/8 14:19
 */
public class BlockingQueueMethodTest {

    private static ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) {
        add();
        remove();
        element();

        offer();
        poll();
        peek();
    }

    private static void peek() {
        System.out.println(abq.peek()); // null
    }

    private static void poll() {
        abq.offer(1);
        abq.offer(2);
        System.out.println(abq.poll()); // 1
        System.out.println(abq.poll()); // 2
        System.out.println(abq.poll()); // null
    }

    private static void offer() {
        System.out.println(abq.offer(1)); // true
        System.out.println(abq.offer(2)); // true
        System.out.println(abq.offer(3)); // false
    }

    private static void element() {
        abq.add(1);
        abq.add(2);
        System.out.println(abq.remove()); // 1
        System.out.println(abq.remove()); // 2
        System.out.println(abq.element());
    }

    private static void remove() {
        abq.add(1);
        abq.add(2);
        System.out.println(abq.remove()); // 1
        System.out.println(abq.remove()); // 2
        System.out.println(abq.remove());
    }

    private static void add() {
        abq.add(1);
        abq.add(2);
        abq.add(3);
    }
}
