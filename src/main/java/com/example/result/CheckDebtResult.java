package com.example.result;

import java.util.List;

public class CheckDebtResult {
    private boolean success;
    private String id;
    private String errorMessage;
    private List<DebtResult> creditors ;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<DebtResult> getCreditors() {
        return creditors;
    }

    public void setCreditors(List<DebtResult> creditors) {
        this.creditors = creditors;
    }
}
