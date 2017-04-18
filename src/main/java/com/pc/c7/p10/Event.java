package com.pc.c7.p10;

/**
 * Created by Switch on 2017/4/18.
 */
public class Event implements Comparable<Event> {
    private String thread;
    private Integer priority;

    public Event(String thread, Integer priority) {
        this.thread = thread;
        this.priority = priority;
    }

    public String getThread() {
        return thread;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Event o) {
        return -this.getPriority().compareTo(o.getPriority());
    }
}
