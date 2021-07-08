package com.example.request;

public class ReplySessionRequest {
    private String sessionId;
    private String receiverMove;
    private String receiverNo;

    public String getReceiverNo() {
        return receiverNo;
    }

    public void setReceiverNo(String receiverNo) {
        this.receiverNo = receiverNo;
    }

    private boolean accept;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getReceiverMove() {
        return receiverMove;
    }

    public void setReceiverMove(String receiverMove) {
        this.receiverMove = receiverMove;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}