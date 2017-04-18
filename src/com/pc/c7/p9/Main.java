package com.pc.c7.p9;

import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyLock lock = new MyLock();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(lock, "Task-" + i);
            Thread thread = new Thread(task);
            thread.start();
        }
        boolean value;
        do {
            try {
                value = lock.tryLock(1, TimeUnit.SECONDS);
                if (!value) {
                    System.out.printf("Main: Trying to get the Lock\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                value = false;
            }
        } while (!value);

        System.out.printf("Main: Got the lock\n");
        lock.unlock();
        System.out.printf("Main: End of the program\n");
    }
}
