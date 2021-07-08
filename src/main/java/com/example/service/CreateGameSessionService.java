package com.example.service;

import com.example.StatusEnum.StatusEnum;
import com.example.request.CreateGameSessionRequest;
import com.example.result.CreateGameSessionResult;
import com.example.result.CreateUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
public class CreateGameSessionService {

    @Autowired
    private DataSource dataSource;

    public CreateGameSessionResult createGameSession(CreateGameSessionRequest createGameSessionRequest) {
        CreateGameSessionResult createGameSessionResult = new CreateGameSessionResult();
        createGameSessionResult.setSessionID(createGameSessionRequest.getSessionID());
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement st = connection.prepareStatement("INSERT INTO session (session_id,sender_no,receiver_no,sender_move,status) VALUES(?,?,?,?,?)");
            st.setString(1,createGameSessionRequest.getSessionID());
            st.setString(2,createGameSessionRequest.getSenderNo());
            st.setString(3,createGameSessionRequest.getReceiverNo());
            st.setString(4,createGameSessionRequest.getSenderMove());
            st.setString(5, StatusEnum.PENDING.toString());
            st.executeUpdate();
            createGameSessionResult.setSuccess(true);
        } catch (Exception e){
            createGameSessionResult.setSuccess(false);
            createGameSessionResult.setErrorMessage(e.getMessage());
            e.printStackTrace();
        }
        return createGameSessionResult;
    }
}

