package com.pc.c5.p2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Switch on 2017/4/7.
 */
public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
