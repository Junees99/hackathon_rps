package com.example.controller;

import com.example.request.CreateUserRequest;
import com.example.request.MobileNoReq;
import com.example.result.CreateUserResult;
import com.example.service.CreateUserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class CreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping(value = "/createUser")
    public CreateUserResult createUser(@RequestBody CreateUserRequest createUserRequest){
        return createUserService.createUser(createUserRequest);
    }


}
