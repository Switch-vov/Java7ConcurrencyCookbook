package com.pc.c5.p4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Switch on 2017/4/12.
 */
public class FolderProcessor extends RecursiveTask<List<String>> {
    private String path;
    private String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();

        File file = new File(this.path);
        File[] content = file.listFiles();
        if (content != null) {
            for (File f : content) {
                if (f.isDirectory()) {
                    FolderProcessor task = new FolderProcessor(f.getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                } else {
                    if (checkFile(f.getName())) {
                        list.add(f.getAbsolutePath());
                    }
                }
            }
        }
        if (tasks.size() > 50) {
            System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
        }
        addResultsFromTasks(list, tasks);

        return list;
    }

    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor task : tasks) {
            list.addAll(task.join());
        }
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }
}
