package com.pc.c6.p9;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Switch on 2017/4/17.
 */
public class Incrementer implements Runnable {
    private AtomicIntegerArray vector;

    public Incrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndIncrement(i);
        }
    }
}
