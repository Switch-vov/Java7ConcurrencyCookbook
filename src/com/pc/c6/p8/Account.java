package com.pc.c6.p8;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Switch on 2017/4/17.
 */
public class Account {
    private AtomicLong balance;

    public Account() {
        this.balance = new AtomicLong();
    }

    public long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }

    public void subtractAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }
}
