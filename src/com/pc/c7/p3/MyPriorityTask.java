package com.pc.c7.p3;

import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/17.
 */
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
    private Integer priority;
    private String name;

    public MyPriorityTask(Integer priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public int compareTo(MyPriorityTask task) {
        return -this.getPriority().compareTo(task.getPriority());
    }

    @Override
    public void run() {
        System.out.printf("MyPriorityTask: %s Priority : %d\n", name, priority);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
