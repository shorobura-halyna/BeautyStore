package com.beautystore.controller;

import com.beautystore.dto.request.UserLoginRequest;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.model.User;
import com.beautystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    public static UserResponse user;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        user = userService.login(userLoginRequest);
        return user;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public HttpStatus logout() {
        user = null;
        return HttpStatus.OK;
    }
}

