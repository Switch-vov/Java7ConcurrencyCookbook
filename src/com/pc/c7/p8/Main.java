package com.pc.c7.p8;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Switch on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int array[] = new int[10000];
        ForkJoinPool pool = new ForkJoinPool();
        Task task = new Task("Task", array, 0, array.length);
        pool.invoke(task);
        pool.shutdown();
        System.out.printf("Main: End of the program.\n");
    }
}
