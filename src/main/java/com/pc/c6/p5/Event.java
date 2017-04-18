package com.pc.c6.p5;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Switch on 2017/4/13.
 */
public class Event implements Delayed {
    private Date startDate;

    public Event(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public int compareTo(Delayed delayed) {
        long result = this.getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }
}
