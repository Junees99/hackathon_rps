package com.example.StatusEnum;

public enum Move {
    ROCK("ROCK"),

    PAPER("PAPER"),

    SCISSOR("SCISSOR");



    private String code;

    Move (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
