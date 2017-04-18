package com.pc.c2.p5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Switch on 2017/4/1.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue:Printing a Job during " + (duration / 1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
