package com.pc.c8.p10;

import edu.umd.cs.mtc.TestFramework;

/**
 * Created by Switch on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) throws Throwable {
        ProducerConsumerTest test = new ProducerConsumerTest();
        System.out.printf("Main: Starting the test\n");
        TestFramework.runOnce(test);
        System.out.printf("Main: The test has finished\n");
    }
}
