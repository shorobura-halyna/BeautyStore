package com.beautystore.controller;

import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.model.User;
import com.beautystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public HttpStatus save(@RequestParam String userFirstName,
                           @RequestParam String userSecondName) {
        User user = new User();
        user.setFirstName(userFirstName);
        user.setSecondName(userSecondName);
        userService.save(user);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam int phone) {
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        userService.save(user);
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<UserResponse> findAll(@RequestParam Integer page,
                                              @RequestParam Integer size,
                                              @RequestParam String sortBy,
                                              @RequestParam Sort.Direction direction,
                                              @RequestParam (required = false) String lastName) {
        return userService.findAll(page, size, sortBy, direction, lastName);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        userService.delete(id);
        return HttpStatus.OK;
    }

}
