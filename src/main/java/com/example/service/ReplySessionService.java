package com.example.service;

import com.example.StatusEnum.Move;
import com.example.StatusEnum.StatusEnum;
import com.example.StatusEnum.Winning;
import com.example.request.ReplySessionRequest;
import com.example.result.ReplySessionResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ReplySessionService {

    @Autowired
    private DataSource dataSource;

    public ReplySessionResult replySession(ReplySessionRequest replySessionRequest){
        ReplySessionResult replySessionResult = new ReplySessionResult();
        replySessionResult.setId(replySessionRequest.getSessionId());
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement st = st = connection.prepareStatement("SELECT status, receiver_no FROM session where session_id = ?"
                    ,ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            st.setString(1, replySessionRequest.getSessionId());
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()){

                if (!StatusEnum.PENDING.getCode().equals(resultSet.getString("status"))){
                    throw new Exception("Session already COMPLETED / CANCELLED");
                }

                if (!StringUtils.equals(replySessionRequest.getReceiverNo(),resultSet.getString("receiver_no"))){
                    throw new Exception("You are not authorized to reply to this game");
                }

            }else {
                throw new Exception("Session ID does not exist");
            }

            if (!replySessionRequest.getAccept()){

                st = st = connection.prepareStatement("UPDATE session SET status = ?  WHERE session_id = ?",ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                st.setString(1, StatusEnum.CANCELLED.getCode());
                st.setString(2, replySessionRequest.getSessionId());
                st.executeUpdate();

            }else {

                st = st = connection.prepareStatement("UPDATE session SET receiver_move = ?  WHERE session_id = ?",ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                st.setString(1, replySessionRequest.getReceiverMove());
                st.setString(2, replySessionRequest.getSessionId());
                st.executeUpdate();

                st = connection.prepareStatement("SELECT * FROM session WHERE session_id = ?",ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                st.setString(1, replySessionRequest.getSessionId());
                 resultSet = st.executeQuery();
                if (resultSet.next()) {
                    String winnerNo = decideWinner(resultSet);
                    if (winnerNo.equals("0000")) {
                        st = connection.prepareStatement("UPDATE session SET winner_no = ? status = ?  WHERE session_id = ?",ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        st.setString(1, winnerNo);
                        st.setString(2, StatusEnum.COMPLETED.getCode());
                        st.setString(3, replySessionRequest.getSessionId());
                    } else {
                        st = connection.prepareStatement("UPDATE session SET winner_no = ? status = ?  WHERE session_id = ?",ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        st.setString(1, winnerNo);
                        st.setString(2, StatusEnum.PAYMENT_PENDING.getCode());
                        st.setString(3, replySessionRequest.getSessionId());
                    }

                    if (winnerNo.equals(resultSet.getString("sender_no"))) {
                        replySessionResult.setWinning(Winning.LOSE.getCode());
                    } else if (winnerNo.equals(resultSet.getString("receiver_no"))) {
                        replySessionResult.setWinning(Winning.WIN.getCode());
                    } else {
                        replySessionResult.setWinning(Winning.DRAW.getCode());
                    }
                }
            }
            replySessionResult.setSuccess(true);
        } catch (Exception e){
            replySessionResult.setSuccess(false);
            replySessionResult.setErrorMessage(e.getMessage());

            e.printStackTrace();
        }
        return replySessionResult;
    }

    private String decideWinner(ResultSet resultSet) throws SQLException {
        resultSet.first();
        String senderMove = resultSet.getString("sender_move");
        String receiverMove = resultSet.getString("receiver_move");
        String senderNo = resultSet.getString("sender_no");
        String receiverNo = resultSet.getString("receiver_no");

        if (StringUtils.equals(senderMove,receiverMove)){
            return "0000";
        }

       if (Move.ROCK.getCode().equals(senderMove) && Move.PAPER.getCode().equals(receiverMove)){
               return receiverNo;
       }

       if (Move.PAPER.getCode().equals(senderMove) && Move.SCISSOR.getCode().equals(receiverMove)){
               return receiverNo;
       }

       if (Move.SCISSOR.getCode().equals(senderMove) && Move.ROCK.getCode().equals(receiverMove)){
               return receiverNo;
       }

       return senderNo;
    }




}


