package com.pc.c5.p2;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Switch on 2017/4/7.
 */
public class Task extends RecursiveAction {
    private List<Product> products;

    private int first;
    private int last;

    private double incement;

    public Task(List<Product> products, int first, int last, double incement) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.incement = incement;
    }

    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks: %s\n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle + 1, incement);
            Task t2 = new Task(products, middle + 1, last, incement);
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + incement));
        }
    }
}
