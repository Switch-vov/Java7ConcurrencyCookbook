package com.pc.c6.p8;

/**
 * Created by Switch on 2017/4/17.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.account.addAmount(1000);
        }
    }
}
