package com.pc.c6.p9;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Switch on 2017/4/17.
 */
public class Decrementer implements Runnable {
    private AtomicIntegerArray vecotr;

    public Decrementer(AtomicIntegerArray vecotr) {
        this.vecotr = vecotr;
    }

    @Override
    public void run() {
        for (int i = 0; i < vecotr.length(); i++) {
            vecotr.getAndDecrement(i);
        }
    }
}
