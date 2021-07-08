package com.example.controller;

import com.example.request.ReplySessionRequest;
import com.example.result.ReplySessionResult;
import com.example.service.ReplySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class ReplySessionController {

    @Autowired
    private ReplySessionService replySessionService;

    @PostMapping(value = "/replySession")
    public ReplySessionResult replyGameSession(@RequestBody ReplySessionRequest requestData){
        return replySessionService.replySession(requestData);
    }

}
