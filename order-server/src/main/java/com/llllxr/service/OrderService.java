package com.llllxr.service;

import com.llllxr.client.UserClient;
import com.llllxr.mapper.OrderMapper;
import com.llllxr.pojo.Order;
import com.llllxr.pojo.User;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private static final String DEBUG_LOG_STRING_FORMAT = "{}: {}";

    @Autowired
    private OrderMapper orderMapper;

    private final UserClient userClient;

    public Order findOrderById(Integer id) {
//        Order order = orderMapper.find(id);
//        User user = userClient.findUserById(id);
//        order.setUser(user);
//        return order;
        try {
            Order order = orderMapper.find(id);
            User user = userClient.findUserById(id);
            order.setUser(user);
            return order;

        }  catch (FeignException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
