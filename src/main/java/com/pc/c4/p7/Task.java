package com.pc.c4.p7;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Switch on 2017/4/7.
 */
public class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
        return "Hello, world";
    }
}
