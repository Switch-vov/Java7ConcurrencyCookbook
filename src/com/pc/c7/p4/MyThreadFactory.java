package com.pc.c7.p4;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Switch on 2017/4/17.
 */
public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String prefix;

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
        counter = 1;
    }

    @Override
    public Thread newThread(Runnable r) {
        MyThread myThread = new MyThread(r, prefix + "-" + counter);
        counter++;
        return myThread;
    }
}
