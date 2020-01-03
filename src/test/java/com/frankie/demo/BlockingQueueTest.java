package com.frankie.demo;

import com.frankie.demo.blockingQueue.Consumer;
import com.frankie.demo.blockingQueue.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: Yao Frankie
 * @date: 2020/1/3 20:51
 */
@SpringBootTest
public class BlockingQueueTest {

    @Test
    public void producerConsumerTest() throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
