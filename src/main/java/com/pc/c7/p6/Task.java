package com.pc.c7.p6;

import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/17.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.printf("Task: Begin.\n");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task: End.\n");
    }
}
