package com.example.controller;

import com.example.request.CreateGameSessionRequest;
import com.example.result.CreateGameSessionResult;
import com.example.service.CreateGameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class CreateGameSessionController {

    @Autowired
    private CreateGameSessionService createGameSessionService;

    @PostMapping(value = "/createGameSession")
    public CreateGameSessionResult createGameSession(@RequestBody CreateGameSessionRequest requestData){
        return createGameSessionService.createGameSession(requestData);
    }

}
