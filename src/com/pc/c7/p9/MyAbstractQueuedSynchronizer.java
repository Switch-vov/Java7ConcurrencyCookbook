package com.pc.c7.p9;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by Switch on 2017/4/17.
 */
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {
    private AtomicInteger state;

    public MyAbstractQueuedSynchronizer() {
        state = new AtomicInteger(0);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return state.compareAndSet(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return state.compareAndSet(1, 0);
    }
}
