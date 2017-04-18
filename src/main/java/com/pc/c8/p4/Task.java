package com.pc.c8.p4;

import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/18.
 */
public class Task implements Runnable {
    private long milliseconds;

    public Task(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：Begin");
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "：End");
    }
}
