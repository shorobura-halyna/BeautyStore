package com.beautystore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController  {

    @GetMapping
    public HttpStatus index(){
        return HttpStatus.OK;
    }

}
