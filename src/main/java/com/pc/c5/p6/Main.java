package com.pc.c5.p6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/7.
 */
public class Main {
    public static void main(String[] args) {
        ArrayGenerator generator = new ArrayGenerator();
        int array[] = generator.generateArray(1000);
        TaskManager manager = new TaskManager();
        ForkJoinPool pool = new ForkJoinPool();
        SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);
        pool.execute(task);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: The program has finished\n");
    }
}
