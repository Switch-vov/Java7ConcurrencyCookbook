package com.pc.c5.p4;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/7.
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor capps = new FolderProcessor("C:\\Program Files", "log");
        FolderProcessor daaps = new FolderProcessor("D:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Users\\82441\\Documents", " log");
        pool.execute(capps);
        pool.execute(daaps);
        pool.execute(documents);
        do {
            System.out.printf("*******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("*******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!capps.isDone()) || (!daaps.isDone()) || (!documents.isDone()));
        pool.shutdown();
        List<String> results;
        results = capps.join();
        System.out.printf("Capps: %d files found.\n", results.size());
        results = daaps.join();
        System.out.printf("Daaps: %d files found.\n", results.size());
        results = documents.join();
        System.out.printf("Documents: %d files found.\n", results.size());
    }
}
