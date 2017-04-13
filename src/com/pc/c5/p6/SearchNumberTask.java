package com.pc.c5.p6;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/13.
 */
public class SearchNumberTask extends RecursiveTask<Integer> {
    private int[] numbers;
    private int start;
    private int end;
    private int number;
    private TaskManager manager;
    private final static int NOT_FOUND = -1;

    public SearchNumberTask(int[] numbers, int start, int end, int number, TaskManager manager) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.number = number;
        this.manager = manager;
    }

    @Override
    protected Integer compute() {
        System.out.println("Task: " + start + ":" + end);
        int ret;
        if (this.end - this.start > 10) {
            ret = launchTasks();
        } else {
            ret = lookForNumber();
        }
        return ret;
    }

    private int lookForNumber() {
        for (int i = this.start; i < this.end; i++) {
            if (numbers[i] == number) {
                System.out.printf("Task: Number %d found in position %d\n", number, i);
                manager.canelTasks(this);
                return i;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return NOT_FOUND;
    }

    private int launchTasks() {
        int mid = (start + end) / 2;
        SearchNumberTask task1 = new SearchNumberTask(numbers, start, mid, number, manager);
        SearchNumberTask task2 = new SearchNumberTask(numbers, mid, end, number, manager);
        manager.addTask(task1);
        manager.addTask(task2);
        task1.fork();
        task2.fork();
        int returnValue;
        returnValue = task1.join();
        if (returnValue != -1) {
            return returnValue;
        }
        returnValue = task2.join();
        return returnValue;
    }

    public void writeCancelMessage() {
        System.out.printf("Task: Canceled task from %d to %d\n", start, end);
    }
}
