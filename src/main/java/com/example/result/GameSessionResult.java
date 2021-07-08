package com.example.result;

public class GameSessionResult {
    private String sessionId;
    private String senderNo;
    private String senderMove;
    private String receiverNo;
    private String receiverMove;
    private String status;
    private String winnerNo;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSenderNo() {
        return senderNo;
    }

    public void setSenderNo(String senderNo) {
        this.senderNo = senderNo;
    }

    public String getSenderMove() {
        return senderMove;
    }

    public void setSenderMove(String senderMove) {
        this.senderMove = senderMove;
    }

    public String getReceiverNo() {
        return receiverNo;
    }

    public void setReceiverNo(String receiverNo) {
        this.receiverNo = receiverNo;
    }

    public String getReceiverMove() {
        return receiverMove;
    }

    public void setReceiverMove(String receiverMove) {
        this.receiverMove = receiverMove;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWinnerNo() {
        return winnerNo;
    }

    public void setWinnerNo(String winnerNo) {
        this.winnerNo = winnerNo;
    }
}
