package com.frankie.demo;

import com.frankie.demo.core_tech.HashSelfPrivateNum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 20:28
 */
@SpringBootTest
public class coreTechTest {

    private int count = 1;

    @Test
    public void methodPrivateNumTest() throws InterruptedException {
        HashSelfPrivateNum numRef = new HashSelfPrivateNum();

        Thread threadA = new Thread(() -> numRef.addNum("a"));
        Thread threadB = new Thread(() -> numRef.addNum("b"));
        threadA.start();
        threadB.start();

        Thread.sleep(1500);
    }

    @Test
    public void accessInstanceVariableTest(){
        System.out.println("count = " + count);
    }
}
