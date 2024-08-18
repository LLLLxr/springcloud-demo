package com.llllxr.client;

import com.llllxr.config.OpenfeignConfig;
import com.llllxr.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-server", configuration = OpenfeignConfig.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User findUserById(@PathVariable("id") int id);
}
