package com.example.result;

public class CreateGameSessionResult {
    private boolean success;
    private String sessionID;
    private String errorMessage;

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getSessionID() {
        return sessionID;
    }

    public boolean getSuccess(){
        return success;
    }
}
