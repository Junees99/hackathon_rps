package com.example.controller;

import com.example.request.MobileNoReq;
import com.example.result.RetrieveGameSessionResult;
import com.example.service.RetrieveGameSessionService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class RetrieveGameSessionsController{

    @Autowired
    private RetrieveGameSessionService retrieveGameSessionService;

    @PostMapping(value = "/requestSession")
    public RetrieveGameSessionResult createUser(@RequestBody MobileNoReq mobileNoReq){
        return retrieveGameSessionService.retrieveGameSessionResult(mobileNoReq);
    }


}
