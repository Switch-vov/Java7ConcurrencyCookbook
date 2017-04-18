package com.pc.c7.p7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by Switch on 2017/4/17.
 */
public class MyWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {
    @Override
    public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        return new MyWorkerThread(pool);
    }
}
