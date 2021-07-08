package com.example.result;

public class DebtResult {
    private String name;
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    private String mobile_no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
