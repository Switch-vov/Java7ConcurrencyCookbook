package com.pc.c8.p7;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Switch on 2017/4/18.
 */
public class Main {
    private static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(lock);
            Thread thread = new Thread(task);
            thread.run();
        }
    }
}
