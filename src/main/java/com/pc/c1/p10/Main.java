package com.pc.c1.p10;

import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/1.
 */
public class Main {
    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
