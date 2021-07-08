package com.example.StatusEnum;

public enum Winning {
    WIN("WIN"),

    LOSE("LOSE"),

    DRAW("DRAW");


    private String code;

    Winning (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
