package com.pc.c7.p11;

/**
 * Created by Switch on 2017/4/18.
 */
public class Sensor2 implements Runnable {
    private ParkingCounter counter;

    public Sensor2(ParkingCounter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        counter.carIn();
        counter.carOut();
        counter.carOut();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
    }
}
