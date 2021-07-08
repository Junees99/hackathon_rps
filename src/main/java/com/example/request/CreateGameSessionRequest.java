package com.example.request;

public class CreateGameSessionRequest {
    private String senderNo;
    private String receiverNo;
    private String senderMove;
    private String sessionID;
    private Double amount;

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setReceiverNo(String receiverNo) {
        this.receiverNo = receiverNo;
    }

    public void setSenderMove(String senderMove) {
        this.senderMove = senderMove;
    }

    public void setSenderNo(String senderNo) {
        this.senderNo = senderNo;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getReceiverNo() {
        return receiverNo;
    }

    public String getSenderMove() {
        return senderMove;
    }

    public String getSenderNo() {
        return senderNo;
    }

    public String getSessionID() {
        return sessionID;
    }
}
