package com.llllxr.service;

import com.llllxr.mapper.OrderMapper;
import com.llllxr.pojo.Order;
import com.llllxr.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    private static final String DEBUG_LOG_STRING_FORMAT = "{}: {}";

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order findOrderById(Integer id) {
        try {
            Order order = orderMapper.find(id);
            String url = "http://user-server/user/" + order.getUserId();
            log.debug("Calling order with url: {}; requestDto: {}", url, order.getUserId());
            ResponseEntity<User> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );

            log.debug(DEBUG_LOG_STRING_FORMAT, "response", response);
            User user = response.getBody();
            order.setUser(user);
            return order;

        }  catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
