package com.pc.c7.p4;

/**
 * Created by Switch on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");
        MyTask task = new MyTask();
        Thread thread = myFactory.newThread(task);
        thread.start();
        thread.join();
        System.out.printf("Main: Thread information.\n");
        System.out.printf("%s\n", thread);
        System.out.printf("Main: End of the example.\n");
    }
}
