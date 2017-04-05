package com.pc.c1.p11;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/1.
 */
public class SearchTask implements Runnable {
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread " + name + " Start");
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " Interrupted");
            return;
        }
    }

    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.println("Thread " + Thread.currentThread().getName() + "：" + value);
        TimeUnit.SECONDS.sleep(value);
    }
}
