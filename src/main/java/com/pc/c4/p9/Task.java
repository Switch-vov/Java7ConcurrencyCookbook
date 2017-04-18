package com.pc.c4.p9;

import java.util.concurrent.Callable;

/**
 * Created by Switch on 2017/4/7.
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true) {
            System.out.printf("Task: Test\n");
            Thread.sleep(1000);
        }
    }
}
