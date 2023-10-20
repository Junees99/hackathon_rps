package com.example.controller;

import com.example.request.MobileNoReq;
import com.example.result.CheckDebtResult;
import com.example.result.CreateUserResult;
import com.example.service.CheckDebtService;
import com.example.service.CreateUserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class CheckDebtController {

    @Autowired
    private CheckDebtService checkDebtService;


    //etetst
    @PostMapping(value = "/checkDebt")
    public CheckDebtResult checkDebt(@RequestBody MobileNoReq mobileNoReq){
       return checkDebtService.checkDebt(mobileNoReq);
    }


}
