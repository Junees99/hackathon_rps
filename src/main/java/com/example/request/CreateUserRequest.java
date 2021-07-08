package com.example.request;

public class CreateUserRequest {
    private String mobile_no;
    private String name;

    public String getMobile_no() {
        return mobile_no;
    }

    public String getName() {
        return name;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public void setName(String name) {
        this.name = name;
    }
}
