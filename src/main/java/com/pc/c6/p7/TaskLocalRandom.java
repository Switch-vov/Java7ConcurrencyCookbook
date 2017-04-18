package com.pc.c6.p7;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Switch on 2017/4/13.
 */
public class TaskLocalRandom implements Runnable {
    public TaskLocalRandom() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: %d\n",name,ThreadLocalRandom.current().nextInt(10));
        }
    }
}
