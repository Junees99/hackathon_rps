package com.example.service;

import com.example.StatusEnum.StatusEnum;
import com.example.request.MobileNoReq;
import com.example.result.CheckDebtResult;
import com.example.result.DebtResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class CheckDebtService {

    @Autowired
    private DataSource dataSource;

    public CheckDebtResult checkDebt(MobileNoReq mobileNoReq){
        String mobile_no = mobileNoReq.getMobile_no();
        CheckDebtResult checkDebtResult = new CheckDebtResult();
        checkDebtResult.setId(mobile_no);
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement st = connection.prepareStatement("SELECT * FROM session WHERE (sender_no = ? OR receiver_no = ?) AND (winner_no != ? AND status = ?)"
                    ,ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            st.setString(1,mobile_no);
            st.setString(2,mobile_no);
            st.setString(3,mobile_no);
            st.setString(4,StatusEnum.PAYMENT_PENDING.getCode());
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()){
                ArrayList<DebtResult> debtResultArrayList = new ArrayList<>();
                do {
                    DebtResult debtResult = new DebtResult();
                    String creditorNo = resultSet.getString("sender_no");;
                    if (!StringUtils.equals(creditorNo,resultSet.getString("winner_no"))){
                        creditorNo = resultSet.getString("receiver_no");
                    }
                    PreparedStatement statement = connection.prepareStatement("SELECT name FROM users WHERE mobile_no = ?");
                    statement.setString(1,creditorNo);
                    ResultSet resultSet1 = statement.executeQuery();
                    String creditorName = "";
                    if (resultSet1.next()){
                        creditorName = resultSet1.getString("name");
                    }
                    debtResult.setName(creditorName);
                    debtResult.setMobile_no(creditorNo);
                    debtResult.setAmount(resultSet.getDouble("amount"));
                    debtResultArrayList.add(debtResult);
                }while (resultSet.next());
                checkDebtResult.setCreditors(debtResultArrayList);
            }

            checkDebtResult.setSuccess(true);

        } catch (Exception e){
            checkDebtResult.setSuccess(false);
            checkDebtResult.setErrorMessage(e.getMessage());
            e.printStackTrace();
        }

        return checkDebtResult;
    }
}
