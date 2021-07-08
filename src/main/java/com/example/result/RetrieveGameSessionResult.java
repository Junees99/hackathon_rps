package com.example.result;

import java.util.List;

public class RetrieveGameSessionResult {
    private boolean success;
    private String id;
    private String errorMessage;

    private List<GameSessionResult> initiatedGameSessionResultList;
    private List<GameSessionResult> invitedGameSessionResultList;

    public List<GameSessionResult> getInitiatedGameSessionResultList() {
        return initiatedGameSessionResultList;
    }

    public void setInitiatedGameSessionResultList(List<GameSessionResult> initiatedGameSessionResultList) {
        this.initiatedGameSessionResultList = initiatedGameSessionResultList;
    }

    public List<GameSessionResult> getInvitedGameSessionResultList() {
        return invitedGameSessionResultList;
    }

    public void setInvitedGameSessionResultList(List<GameSessionResult> invitedGameSessionResultList) {
        this.invitedGameSessionResultList = invitedGameSessionResultList;
    }

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


}
