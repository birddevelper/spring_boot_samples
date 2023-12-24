package com.msaheri.springbootfeaturedemo.firstMadule.controller;

import com.msaheri.springbootfeaturedemo.firstMadule.model.Student;
import com.msaheri.springbootfeaturedemo.firstMadule.remoteMethod.StudentClient;
import com.msaheri.springbootfeaturedemo.firstMadule.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class accountTransactionController {

    @Autowired
    AccountTransactionService accountTransactionService;


    @Autowired
    StudentClient studentClient;

    @GetMapping(value = "hi", produces = "application/json")
    public String sayHi(){
        return "{\"message\" : \"Hi Dear " + SecurityContextHolder.getContext().getAuthentication().getName() + "\"}";
    }


    @GetMapping(value= "/add", produces = "application/json")
    public String add(float amount) throws InterruptedException {

        accountTransactionService.addAmount(amount,"desc ");

        return "{\"message\": \"ok\"}";
    }

    @GetMapping(value= "/count", produces = "application/json")
    public String count() throws InterruptedException {

        long count =  accountTransactionService.getCount();
        return "{\"count\": " + count + "}";

    }



    @GetMapping(value= "/student", produces = "application/json")
    public Student student(@RequestParam int id)  {


        return studentClient.getStudentById(id);

    }
}
