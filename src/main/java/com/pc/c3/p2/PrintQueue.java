package com.pc.c3.p2;

import java.util.concurrent.Semaphore;

/**
 * Created by Switch on 2017/4/5.
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
