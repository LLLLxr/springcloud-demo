package com.llllxr.config.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    private Date timestamp;

    @JsonProperty(value = "code")
    private int code;

    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "details")
    private String details;

    @JsonProperty(value = "error")
    private String error;

    @JsonProperty(value = "path")
    private String path;
}
