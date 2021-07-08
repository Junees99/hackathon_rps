package com.example.service;

import com.example.request.MobileNoReq;
import com.example.result.GameSessionResult;
import com.example.result.RetrieveGameSessionResult;
import com.example.util.MobileNoEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class RetrieveGameSessionService {

    @Autowired
    private DataSource dataSource;

    public RetrieveGameSessionResult retrieveGameSessionResult(MobileNoReq mobileNoReq){
        String mobile_no = MobileNoEditor.editMobileNo(mobileNoReq.getMobile_no());
        RetrieveGameSessionResult retrieveGameSessionResult = new RetrieveGameSessionResult();
        retrieveGameSessionResult.setId(mobile_no);

        try (Connection connection = dataSource.getConnection()) {
            ArrayList<GameSessionResult> initiatedGameSessionResultList = new ArrayList<>();
            ArrayList<GameSessionResult> invitedGameSessionResultList = new ArrayList<>();

            String name = "";


            PreparedStatement st = connection.prepareStatement("SELECT * FROM session WHERE sender_no = ?");
            st.setString(1,mobile_no);
            ResultSet senderResultSet = st.executeQuery();
            while (senderResultSet.next()){
                GameSessionResult gameSessionResult = new GameSessionResult();
                gameSessionResult.setSessionId(senderResultSet.getString("session_id"));
                gameSessionResult.setSenderNo(senderResultSet.getString("sender_no"));
                gameSessionResult.setSenderMove(senderResultSet.getString("sender_move"));
                gameSessionResult.setReceiverNo(senderResultSet.getString("receiver_no"));
                gameSessionResult.setReceiverMove(senderResultSet.getString("receiver_move"));
                gameSessionResult.setStatus(senderResultSet.getString("status"));
                gameSessionResult.setWinnerNo(senderResultSet.getString("winner_no"));
                st = connection.prepareStatement("SELECT name FROM users WHERE mobile_no = ?");
                st.setString(1,gameSessionResult.getReceiverNo());
                ResultSet resultSet = st.executeQuery();
                if (resultSet.next()){
                    name = resultSet.getString("name");
                }
                gameSessionResult.setName(name);
                initiatedGameSessionResultList.add(gameSessionResult);
            }

            st = connection.prepareStatement("SELECT * FROM session WHERE receiver_no = ?");
            st.setString(1,mobile_no);
            senderResultSet = st.executeQuery();
            while (senderResultSet.next()){
                GameSessionResult gameSessionResult = new GameSessionResult();
                gameSessionResult.setSessionId(senderResultSet.getString("session_id"));
                gameSessionResult.setSenderNo(senderResultSet.getString("sender_no"));
                gameSessionResult.setSenderMove(senderResultSet.getString("sender_move"));
                gameSessionResult.setReceiverNo(senderResultSet.getString("receiver_no"));
                gameSessionResult.setReceiverMove(senderResultSet.getString("receiver_move"));
                gameSessionResult.setStatus(senderResultSet.getString("status"));
                gameSessionResult.setWinnerNo(senderResultSet.getString("winner_no"));
                gameSessionResult.setName(name);
                st = connection.prepareStatement("SELECT name FROM users WHERE mobile_no = ?");
                st.setString(1,gameSessionResult.getSenderNo());
                ResultSet resultSet1 = st.executeQuery();
                if (resultSet1.next()){
                    name = resultSet1.getString("name");
                }
                invitedGameSessionResultList.add(gameSessionResult);
            }

            retrieveGameSessionResult.setSuccess(true);
            retrieveGameSessionResult.setInitiatedGameSessionResultList(initiatedGameSessionResultList);
            retrieveGameSessionResult.setInvitedGameSessionResultList(invitedGameSessionResultList);

        } catch (Exception e){
            retrieveGameSessionResult.setSuccess(false);
            retrieveGameSessionResult.setErrorMessage(e.getMessage());
            e.printStackTrace();
        }

        return retrieveGameSessionResult;

    }

}
