package com.pc.c8.p2;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Switch on 2017/4/18.
 */
public class MyLock extends ReentrantLock {

    public String getOwnerName() {
        if (this.getOwner() == null) {
            return "None";
        }
        return this.getOwner().getName();
    }

    public Collection<Thread> getThreads() {
        return this.getQueuedThreads();
    }
}
