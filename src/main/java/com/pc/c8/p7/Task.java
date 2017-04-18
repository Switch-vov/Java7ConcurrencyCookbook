package com.pc.c8.p7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Switch on 2017/4/18.
 */
public class Task implements Runnable {
    private ReentrantLock lock;

    public Task(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
