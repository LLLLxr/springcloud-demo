package com.llllxr.config;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 自定义Feign日志工厂
 **/
@Configuration
public class CustomizationFeignLoggerFactory implements FeignLoggerFactory {

    private Logger logger;

    public CustomizationFeignLoggerFactory() {
    }

    public CustomizationFeignLoggerFactory(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Logger create(Class<?> type) {
        return this.logger != null ? this.logger : new CustomizableFeignLogger();
    }

}