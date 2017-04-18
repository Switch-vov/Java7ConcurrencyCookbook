package com.pc.c7.p7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by Switch on 2017/4/17.
 */
public class MyWorkerThread extends ForkJoinWorkerThread {
    private static ThreadLocal<Integer> taskCounter = new ThreadLocal<>();

    protected MyWorkerThread(ForkJoinPool pool) {
        super(pool);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.printf("MyWorkerThread %d: Initializing task counter.\n", getId());
        taskCounter.set(0);
    }

    @Override
    protected void onTermination(Throwable exception) {
        super.onTermination(exception);
        System.out.printf("MyWorkerThread %d: %d\n", getId(), taskCounter.get());
        super.onTermination(exception);
    }

    public void addTask() {
        int counter = taskCounter.get().intValue();
        counter++;
        taskCounter.set(counter);
    }
}
