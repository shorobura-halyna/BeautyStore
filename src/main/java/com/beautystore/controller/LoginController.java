package com.beautystore.controller;

import com.beautystore.model.User;
import com.beautystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public HttpStatus login() {
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus save() {
        User user = new User();
        user.setLogin("userLogin");
        user.setPassword("userPassword");
        userService.save(user);
        return HttpStatus.OK;
    }

}

