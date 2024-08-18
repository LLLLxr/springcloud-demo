package com.llllxr.config.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;


//@Configuration
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String methodKey, Response response) {
        ErrorResponse message = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ErrorResponse.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        switch (response.status()) {
            case 400:
                return new MyException(message.getMessage() != null ? message.getMessage() : "Bad Request");
            case 404:
                return new MyException(message.getMessage() != null ? message.getMessage() : "Not found");
            case 500:
                return new MyException(message.getMessage() != null ? message.getMessage() : "Internal Server Error");
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}
