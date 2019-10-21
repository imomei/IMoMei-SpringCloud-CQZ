package com.imomei.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String id;
    private String orderName;
    private Date orderTime;
}
