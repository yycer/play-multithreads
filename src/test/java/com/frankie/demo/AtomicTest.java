package com.frankie.demo;

import com.frankie.demo.utils.AtomicOperationThread;
import com.frankie.demo.utils.CommonOperationThread;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/1/5 14:17
 */
@SpringBootTest
public class AtomicTest {

    @Test
    public void commonTest() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            new Thread(new CommonOperationThread()).start();
        }
        Thread.sleep(1000);
        System.out.println("Count = " + CommonOperationThread.count);

//        Current thread name is Thread-2
//        Current thread name is Thread-4
//        Current thread name is Thread-3
//        Current thread name is Thread-5
//        Current thread name is Thread-11
//        Current thread name is Thread-6
//        Current thread name is Thread-7
//        Current thread name is Thread-8
//        Current thread name is Thread-10
//        Current thread name is Thread-9
//        Count = 86495

    }

    @Test
    public void atomicTest() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            new Thread(new AtomicOperationThread()).start();
        }
        Thread.sleep(1000);
        System.out.println("Count = " + AtomicOperationThread.count.get());

//        Current thread name is Thread-3
//        Current thread name is Thread-4
//        Current thread name is Thread-2
//        Current thread name is Thread-6
//        Current thread name is Thread-5
//        Current thread name is Thread-7
//        Current thread name is Thread-11
//        Current thread name is Thread-9
//        Current thread name is Thread-10
//        Current thread name is Thread-8
//        Count = 1000000
    }
}
