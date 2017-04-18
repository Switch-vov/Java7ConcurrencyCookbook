package com.pc.c6.p8;

/**
 * Created by Switch on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        Company company = new Company(account);
        Thread companyThread = new Thread(company);
        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);
        companyThread.start();
        bankThread.start();
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account :Final Balance: %d\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
