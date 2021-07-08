package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.exception.APIBaseException;
import jp.co.axa.apidemo.utils.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({APIBaseException.class})
    public RestResponse<Object> resolveErrors(APIBaseException e) {
        LOG.warn("resolved exception: {}", e.getMessage(), e);
        RestResponse<Object> response = new RestResponse<>();
        response.setMessage(e.getMessage());
        response.setSuccess(false);
        return response;
    }
}
