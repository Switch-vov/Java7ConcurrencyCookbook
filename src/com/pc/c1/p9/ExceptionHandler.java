package com.pc.c1.p9;

/**
 * Created by Switch on 2017/4/1.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Thread :" + t.getId());
        System.out.println("Exception：" + e.getClass().getName() + " : " + e.getMessage());
        System.out.println();
        e.printStackTrace(System.out);
        System.out.println("Thread status：" + t.getState());
    }
}
