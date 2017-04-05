package com.pc.c1.p13;

import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/1.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}