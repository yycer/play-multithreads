package com.frankie.demo;

import com.frankie.demo.producer_consumer.Consumer;
import com.frankie.demo.producer_consumer.Message;
import com.frankie.demo.producer_consumer.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: Yao Frankie
 * @date: 2020/1/3 15:28
 */
@SpringBootTest
public class ProducerConsumerTest {

    @Test
    public void producerConsumerTest() throws InterruptedException {
        ArrayBlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}
