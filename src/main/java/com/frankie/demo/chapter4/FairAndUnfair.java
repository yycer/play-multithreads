package com.frankie.demo.chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yao Frankie
 * @date: 2020/7/7 10:26
 */
public class FairAndUnfair {

    public static void main(String[] args) throws InterruptedException {
        PrintQueue pq = new PrintQueue();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 5; i++){
            threads[i] = new Thread(new Job(pq), "Thread " + i);
        }

        for (int i = 0; i < 5; i++){
            threads[i].start();
            Thread.sleep(100);
        }
    }

    static class Job implements Runnable{

        private PrintQueue queue;

        public Job(PrintQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
            queue.printJob();
            System.out.printf("%s: Done\n", Thread.currentThread().getName());
        }
    }

    static class PrintQueue{
//        private final Lock lock = new ReentrantLock(true);
        private final Lock lock = new ReentrantLock(false);

        public void printJob(){
            lock.lock();
            try {
                long duration = (long) (Math.random() * 10000);
                System.out.printf("%s: Printing a Job during %d seconds\n",
                        Thread.currentThread().getName(), (duration / 1000));
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            lock.lock();
            try {
                long duration = (long) (Math.random() * 10000);
                System.out.printf("%s: Printing a Job during %d seconds\n",
                        Thread.currentThread().getName(), (duration / 1000));
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /** Fair **/
//    Thread 0: Going to print a job
//    Thread 0: Printing a Job during 9 seconds
//    Thread 1: Going to print a job
//    Thread 2: Going to print a job
//    Thread 3: Going to print a job
//    Thread 4: Going to print a job
//    Thread 1: Printing a Job during 0 seconds
//    Thread 2: Printing a Job during 7 seconds
//    Thread 3: Printing a Job during 9 seconds
//    Thread 4: Printing a Job during 3 seconds
//    Thread 0: Printing a Job during 9 seconds
//    Thread 0: Done
//    Thread 1: Printing a Job during 3 seconds
//    Thread 1: Done
//    Thread 2: Printing a Job during 8 seconds
//    Thread 2: Done
//    Thread 3: Printing a Job during 0 seconds
//    Thread 3: Done
//    Thread 4: Printing a Job during 5 seconds
//    Thread 4: Done
//
//    Process finished with exit code 0

    /** Unfair **/
//    Thread 0: Going to print a job
//    Thread 0: Printing a Job during 4 seconds
//    Thread 1: Going to print a job
//    Thread 2: Going to print a job
//    Thread 3: Going to print a job
//    Thread 4: Going to print a job
//    Thread 0: Printing a Job during 8 seconds
//    Thread 0: Done
//    Thread 1: Printing a Job during 6 seconds
//    Thread 1: Printing a Job during 0 seconds
//    Thread 1: Done
//    Thread 2: Printing a Job during 2 seconds
//    Thread 2: Printing a Job during 8 seconds
//    Thread 2: Done
//    Thread 3: Printing a Job during 2 seconds
//    Thread 3: Printing a Job during 5 seconds
//    Thread 3: Done
//    Thread 4: Printing a Job during 9 seconds
//    Thread 4: Printing a Job during 9 seconds
//    Thread 4: Done
//
//    Process finished with exit code 0
}
