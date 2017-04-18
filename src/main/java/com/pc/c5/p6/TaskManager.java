package com.pc.c5.p6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by Switch on 2017/4/13.
 */
public class TaskManager {
    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(ForkJoinTask<Integer> task) {
        tasks.add(task);
    }

    public void canelTasks(ForkJoinTask<Integer> cannelTask) {
        for (ForkJoinTask<Integer> task : tasks) {
            if (task != cannelTask) {
                task.cancel(true);
                ((SearchNumberTask)task).writeCancelMessage();
            }
        }
    }
}
