package com.pc.c3.p5;

/**
 * Created by Switch on 2017/4/5.
 */
public class Results {
    private int[] data;

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return this.data;
    }
}
