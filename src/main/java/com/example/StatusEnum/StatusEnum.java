package com.example.StatusEnum;



public enum StatusEnum {

    PENDING("PENDING"),

    CANCELLED("CANCELLED"),

    PAYMENT_PENDING("PAYMENT_PENDING"),

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
