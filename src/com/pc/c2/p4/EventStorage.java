package com.pc.c2.p4;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Switch on 2017/4/1.
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("Set：" + storage.size());
        notifyAll();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get：" + storage.size() + "：" + ((LinkedList<?>) storage).poll());
        notifyAll();
    }
}
