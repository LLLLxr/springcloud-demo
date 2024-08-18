package com.llllxr.config;

import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static feign.Util.UTF_8;
import static feign.Util.decodeOrDefault;

/**
 * @Description 自定义Feign日志
 **/
@Slf4j
public class CustomizableFeignLogger extends feign.Logger {


    public CustomizableFeignLogger() {
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
//        for method name
//        Request.HttpMethod httpMethod = request.httpMethod();
        String url = request.url();
        String param = "";
        if (request.body() != null) {
            param = new String(request.body(), UTF_8);
        }
        log.info("Calling {} with url: {}; requestDto: {}.",configKey, url, param);
    }

    @Override
    protected void logRetry(String configKey, Level logLevel) {
        log.info(configKey, "---> RETRYING");
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        String result = "";
        try {
            if (response.body() != null) {
                byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                result = decodeOrDefault(bodyData, UTF_8, "Binary data");
                return response.toBuilder().body(bodyData).build();
            }
            return response;
        } finally {
            if (response.status() == 200) {
                log.info(configKey + "---> response:{}.", result);
            } else {
                log.error(configKey + "---> error:{}.", result);
            }
        }
    }

    @Override
    protected IOException logIOException(String configKey, Level logLevel, IOException ioe, long elapsedTime) {
        log.error(configKey + "<--- ERROR {}: {}", ioe.getClass().getSimpleName(), ioe.getMessage());
        StringWriter sw = new StringWriter();
        ioe.printStackTrace(new PrintWriter(sw));
        log.error(configKey + "{}", sw.toString());
        return ioe;
    }
}
