package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.result.CreateUserResult;

import java.sql.Connection;
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
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format("INSERT INTO customer VALUES ('%s','%s')",name,mobile_no));
            createUserResult.setSuccess(true);
        } catch (Exception e){
            createUserResult.setSuccess(false);
            System.out.println("Create user failed");
            e.printStackTrace();
        }
        return createUserResult;
    }
}
