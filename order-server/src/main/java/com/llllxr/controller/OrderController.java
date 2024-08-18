package com.llllxr.controller;

import com.llllxr.pojo.Order;
import com.llllxr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

//    curl http://localhost:8082/order/1
    @GetMapping("/{id}")
    public Order findUserById(@PathVariable("id") int id){
        Order order = orderService.findOrderById(id);
        return order;
    }
}