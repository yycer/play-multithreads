package com.frankie.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/1/5 17:12
 */
@SpringBootTest
public class FinalTest {

    @Test
    public void basicFinalTest(){
        final int a = 1;
        final int b;

//      Cannot assign a value to final variable a.
//      a = 2;
        b = 2;
    }

    @Test
    public void referenceFinalTest(){
        final String[] names = new String[10];
//        The reference of names is [Ljava.lang.String;@11bb3ab
        System.out.println("The reference of names is " + names);
        names[0] = "frankie";
//        The reference of names is [Ljava.lang.String;@11bb3ab
        System.out.println("The reference of names is " + names);

//        0th element in the names is frankie
        System.out.println("0th element in the names is " + names[0]);
    }
}
