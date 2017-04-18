package com.pc.c2.p4;

/**
 * Created by Switch on 2017/4/1.
 */
public class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
