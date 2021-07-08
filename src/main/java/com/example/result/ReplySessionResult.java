package com.example.result;

public class ReplySessionResult {
    private boolean success;
    private String errorMessage;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String winning;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String isWinning() {
        return winning;
    }

    public void setWinning(String winning) {
        this.winning = winning;
    }
}
