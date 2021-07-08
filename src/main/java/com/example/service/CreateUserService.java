package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.result.CreateUserResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            PreparedStatement st = connection.prepareStatement("INSERT INTO TASKS (name,mobile_no) VALUES (?, ?)");
            st.setString(1,name);
            st.setString(2,mobile_no);
            st.executeUpdate();
            createUserResult.setSuccess(true);
        } catch (Exception e){
            createUserResult.setSuccess(false);
            createUserResult.setId("fail jor");
            e.printStackTrace();
        }
        return createUserResult;
    }
}
