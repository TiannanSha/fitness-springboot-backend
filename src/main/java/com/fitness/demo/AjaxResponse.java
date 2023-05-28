package com.fitness.demo;

import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isOk;
    private int statusCode;
    private String message;
    private Object data;

    // very important to have this default constructor, otherwise would get 406 error 
    public AjaxResponse() {

    }

    public AjaxResponse(boolean isOk, int statusCode, String message, Object data) {
        this.isOk = isOk;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static AjaxResponse AjaxSuccessResponseWithData(Object data) {
        return new AjaxResponse(true, 200, "GET REQUEST OK", data);
    }

    public static AjaxResponse AjaxSuccessResponseNoData() {
        return new AjaxResponse(true, 200, "GET REQUEST OK", null);
    }
}