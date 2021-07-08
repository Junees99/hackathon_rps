package com.example.result;

public class CreateUserResult {
    private String id;
    private boolean success;

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


}
