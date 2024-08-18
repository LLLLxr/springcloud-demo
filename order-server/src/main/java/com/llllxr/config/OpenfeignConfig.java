package com.llllxr.config;

import com.llllxr.config.error.RetreiveMessageErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.context.annotation.Bean;

public class OpenfeignConfig extends FeignClientsConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public FeignLoggerFactory feignLoggerFactory() {
        return new CustomizationFeignLoggerFactory();
    }

    @Bean
    ErrorDecoder feignErrorDecoder() {
        return new RetreiveMessageErrorDecoder();
    }
}
