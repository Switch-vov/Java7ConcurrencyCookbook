package com.pc.c4.p2;

/**
 * Created by Switch on 2017/4/5.
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 20; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
