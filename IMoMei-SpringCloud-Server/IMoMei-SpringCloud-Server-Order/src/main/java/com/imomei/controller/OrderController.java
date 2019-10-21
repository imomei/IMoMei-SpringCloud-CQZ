package com.imomei.controller;

import com.imomei.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {
    @GetMapping(value = "/getOrder")
    public Order getOrder() {
        Order order = new Order();
        order.setId("1");
        order.setOrderName("zhangsan");
        order.setOrderTime(new Date());
        return order;
    }
}
