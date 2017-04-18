package com.pc.c7.p4;

import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/17.
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
