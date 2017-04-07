package com.pc.c4.p4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/6.
 */
public class FactorialCalculater implements Callable<Integer> {
    private Integer number;

    public FactorialCalculater(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (number == 0 || number == 1) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
