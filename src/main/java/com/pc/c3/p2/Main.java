package com.pc.c3.p2;

/**
 * Created by Switch on 2017/4/5.
 */
public class Main {
    public static void main(String args[]) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
