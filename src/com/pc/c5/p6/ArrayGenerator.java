package com.pc.c5.p6;

import java.util.Random;

/**
 * Created by Switch on 2017/4/13.
 */
public class ArrayGenerator {
    public int[] generateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
