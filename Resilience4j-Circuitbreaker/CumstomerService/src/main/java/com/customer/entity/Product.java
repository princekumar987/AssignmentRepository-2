package com.customer.entity;

import lombok.Data;

@Data
public class Product {


    private int id;
    private String name;
    private String type;
    private int price;

    public Product(int i, String defaultProduct, String s, int i1) {
        id=i;
        name=defaultProduct;
        type=s;
        price=i1;
    }
}
