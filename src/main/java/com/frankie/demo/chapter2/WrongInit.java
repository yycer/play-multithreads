package com.frankie.demo.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yao Frankie
 * @date: 2020/7/5 19:25
 */
public class WrongInit {

    private static Map<Integer, String> students;

    public WrongInit(){
        new Thread(() -> {
            students = new HashMap<>();
            students.put(1, "Frankie");
            students.put(2, "Jack");
            students.put(3, "Marion");
            students.put(4, "Alina");
        }).start();
    }

    public Map<Integer, String> getStudents(){
        return students;
    }

    public static void main(String[] args) {
        WrongInit init = new WrongInit();
        System.out.println(init.getStudents().get(1));
    }
}
