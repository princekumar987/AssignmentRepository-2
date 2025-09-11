package com.orderservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private int user_id;
    private List<String> items;

}
