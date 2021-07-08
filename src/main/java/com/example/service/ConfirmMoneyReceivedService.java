package com.example.service;

import com.example.StatusEnum.StatusEnum;
import com.example.request.SessionIdReq;
import com.example.result.ConfirmMoneyReceivedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
public class ConfirmMoneyReceivedService {

    @Autowired
    private DataSource dataSource;

    public ConfirmMoneyReceivedResult confirmMoneyReceived(SessionIdReq sessionIdReq){
        String sessionId = sessionIdReq.getSessionId();
        ConfirmMoneyReceivedResult confirmMoneyReceivedResult = new ConfirmMoneyReceivedResult() ;
        confirmMoneyReceivedResult.setId(sessionIdReq.getSessionId());

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement st = connection.prepareStatement("UPDATE session SET status = ? WHERE session_id = ? ");
            st.setString(1, StatusEnum.COMPLETED.getCode());
            st.setString(2,sessionId);
            st.executeUpdate();
            confirmMoneyReceivedResult.setSuccess(true);
        } catch (Exception e){
            confirmMoneyReceivedResult.setSuccess(false);
            confirmMoneyReceivedResult.setErrorMessage(e.getMessage());
            e.printStackTrace();
        }
        return confirmMoneyReceivedResult;
    }
}
