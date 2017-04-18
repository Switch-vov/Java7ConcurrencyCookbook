package com.pc.c7.p11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Switch on 2017/4/18.
 */
public class ParkingCounter extends AtomicInteger {
    private int maxNumber;

    public ParkingCounter(int maxNumber) {
        set(0);
        this.maxNumber = maxNumber;
    }

    public boolean carIn() {
        for (; ; ) {
            int value = get();
            if (value == this.maxNumber) {
                System.out.printf("ParkingCounter: The parking lot is full.\n");
                return false;
            }
            int newValue = value + 1;
            boolean changed = compareAndSet(value, newValue);
            if (changed) {
                System.out.printf("ParkingCounter: A car has entered.\n");
                return true;
            }
        }
    }

    public boolean carOut() {
        for (; ; ) {
            int value = get();
            if (value == 0) {
                System.out.printf("ParkingCounter: The parking lot is empty.\n");
                return false;
            } else {
                int newValue = value - 1;
                boolean changed = compareAndSet(value, newValue);
                if (changed) {
                    System.out.printf("ParkingCounter: A car has gone out.\n");
                    return true;
                }
            }
        }
    }
}
