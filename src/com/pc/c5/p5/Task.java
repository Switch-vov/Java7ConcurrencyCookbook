package com.pc.c5.p5;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/13.
 */
public class Task extends RecursiveTask<Integer> {
    private int[] array;
    private int start;
    private int end;

    public Task(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.printf("Task: Start from %d to %d\n", start, end);
        if (this.end - this.start < 10) {
            if ((3 > this.start) && (3 < this.end)) {
                throw new RuntimeException("This task throws an Exception: Task from " + start + " to " + end);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            int mid = (this.start + this.end) / 2;
            Task task1 = new Task(this.array, this.start, mid);
            Task task2 = new Task(this.array, mid, this.end);
            invokeAll(task1, task2);
        }
        return 0;
    }
}
