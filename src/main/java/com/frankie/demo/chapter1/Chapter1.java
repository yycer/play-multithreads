package com.frankie.demo.chapter1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author: Yao Frankie
 * @date: 2020/7/4 18:43
 */
public class Chapter1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        createThreadUsingRunnable();
        createThreadUsingThread();
        createThreadUsingThreadPool();
        createThreadUsingCallable();

        class BlockingQueue {

            Queue<String> buffer = new LinkedList<String> ();

            public void produce(String data) {
                buffer.add(data);
                notify();
            }

            public String consume() throws InterruptedException {
                while (buffer.isEmpty()) {
                    wait();
                }
                return buffer.remove();
            }
        }


    }

    private static void createThreadUsingCallable() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> ans = service.submit(new CallableTask());
        // 1410647188
        System.out.println(ans.get());
        service.shutdown();
    }

    private static void createThreadUsingThreadPool() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(new RunnableThread());
        service.shutdown();
    }

    private static void createThreadUsingThread() {
        ExtendsThread extendsThread = new ExtendsThread();
        //  继承Thread类创建线程。
        extendsThread.start();
    }

    private static void createThreadUsingRunnable() {
        Thread runnableThread = new Thread(new RunnableThread());
        // 实现Runnable接口创建线程。
        runnableThread.start();
    }
}
