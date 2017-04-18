package com.pc.c8.p6;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Switch on 2017/4/18.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        Logger logger = MyLogger.getLogger(this.getClass().getName());
        logger.entering(Thread.currentThread().getName(), "run()");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.exiting(Thread.currentThread().getName(), "run()", Thread.currentThread());
    }
}
