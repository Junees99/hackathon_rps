package com.example.StatusEnum;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {

    PENDING("PENDING"),

    CANCELLED("CANCELLED"),

    COMPLETED("COMPLETED");



    private String code;

    StatusEnum (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
