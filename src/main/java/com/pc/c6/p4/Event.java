package com.pc.c6.p4;

/**
 * Created by Switch on 2017/4/13.
 */
public class Event implements Comparable<Event> {
    private Integer thread;
    private Integer priority;

    public Event(Integer thread, Integer priority) {
        this.thread = thread;
        this.priority = priority;
    }

    public Integer getThread() {
        return thread;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Event e) {
        return -this.getPriority().compareTo(e.getPriority());
    }
}
