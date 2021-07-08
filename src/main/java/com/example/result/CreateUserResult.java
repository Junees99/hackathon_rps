package com.example.result;

public class CreateUserResult {
    private String id;
    private boolean success;
    private String errorMessage;

    public void setId(String id) {
        this.id = id;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess(){
        return success;
    }

    public String getId() {
        return id;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
