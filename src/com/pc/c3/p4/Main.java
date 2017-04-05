package com.pc.c3.p4;

/**
 * Created by Switch on 2017/4/5.
 */
public class Main {
    public static void main(String args[]) {
        VideoConference conference = new VideoConference(10);
        Thread threadC = new Thread(conference);
        threadC.start();

        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
