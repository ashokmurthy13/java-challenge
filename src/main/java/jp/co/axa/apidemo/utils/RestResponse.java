package jp.co.axa.apidemo.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponse<T> {

    private boolean success;
    private String message;
    private T result;
    private Date timestamp;

    public RestResponse() {
        this.timestamp = new Date();
    }

    public RestResponse(T result) {
        this.result = result;
        this.success = true;
        this.message = "success";
        this.timestamp = new Date();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
