package com.pc.c8.p5;

import java.util.concurrent.RecursiveAction;

/**
 * Created by Switch on 2017/4/18.
 */
public class Task extends RecursiveAction {
    private int[] array;
    private int start;
    private int end;

    public Task(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (this.end - this.start > 100) {
            int mid = (this.start + this.end) / 2;
            Task task1 = new Task(array, this.start, mid);
            Task task2 = new Task(array, mid, this.end);

            task1.fork();
            task2.fork();

            task1.join();
            task2.join();
        } else {
            for (int i = this.start; i < this.end; i++) {
                array[i]++;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
