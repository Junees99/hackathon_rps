package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.result.CreateUserResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;


@Component
public class CreateUserService {

    @Autowired
    private DataSource dataSource;

    public CreateUserResult createUser(String name, String mobile_no) {
        CreateUserResult createUserResult = new CreateUserResult();
        createUserResult.setId(mobile_no);
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM customer WHERE mobile_no = ?");
            st.setString(1,mobile_no);
            ResultSet resultSet = st.executeQuery();
            if (!resultSet.next()){
                createUserResult.setSuccess(true);
                return createUserResult;
            }

            st = connection.prepareStatement("INSERT INTO customer (name,mobile_no) VALUES (?, ?)");
            st.setString(1,name);
            st.setString(2,mobile_no);
            st.executeUpdate();
            createUserResult.setSuccess(true);
        } catch (Exception e){
            createUserResult.setSuccess(false);
            e.printStackTrace();
        }
        return createUserResult;
    }
}
