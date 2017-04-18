package com.pc.c7.p5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
        ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
        MyTask task = new MyTask();
        executor.submit(task);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.printf("Main: End of the program.\n");
    }
}
