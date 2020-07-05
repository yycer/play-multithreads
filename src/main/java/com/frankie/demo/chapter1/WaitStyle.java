package com.frankie.demo.chapter1;

/**
 * @author: Yao Frankie
 * @date: 2020/7/5 15:40
 */
public class WaitStyle {

    public static void main(String[] args) {

        MyBlockingQueue queue = new MyBlockingQueue(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();

    }

    static class Producer implements Runnable{

        private MyBlockingQueue queue;

        public Producer(MyBlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++){
                try {
                    queue.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        private MyBlockingQueue queue;

        public Consumer(MyBlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++){
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
