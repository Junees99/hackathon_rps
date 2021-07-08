package com.example.controller;

import com.example.request.SessionIdReq;
import com.example.result.ConfirmMoneyReceivedResult;
import com.example.service.ConfirmMoneyReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class ConfirmMoneyReceivedController {

    @Autowired
    private ConfirmMoneyReceivedService confirmMoneyReceivedService;

    @PostMapping(value = "/confirmMoneyReceived")
    public ConfirmMoneyReceivedResult createGameSession(@RequestBody SessionIdReq sessionIdReq) {
        return confirmMoneyReceivedService.confirmMoneyReceived(sessionIdReq);
    }
}
