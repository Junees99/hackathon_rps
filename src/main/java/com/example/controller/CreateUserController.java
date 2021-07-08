package com.example.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.result.CreateUserResult;
import com.example.service.CreateUserService;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class CreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping(value = "/createUser")
    public CreateUserResult createUser(@RequestParam String requestData){
        JsonObject jsonObject = new JsonParser().parse(requestData).getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        String mobile_no = jsonObject.get("mobile_no").getAsString();
        return createUserService.createUser(name,mobile_no);
    }


}
