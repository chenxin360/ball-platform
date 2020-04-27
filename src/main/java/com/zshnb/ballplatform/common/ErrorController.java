package com.zshnb.ballplatform.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ErrorController {
    @ExceptionHandler(RuntimeException.class)
    public Response<String> handler(RuntimeException e) {
        return Response.error(e.getMessage());
    }

}
