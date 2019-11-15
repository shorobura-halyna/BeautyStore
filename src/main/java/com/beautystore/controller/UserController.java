package com.beautystore.controller;

import com.beautystore.dto.request.UserRequest;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public HttpStatus save(@RequestBody @Valid UserRequest userRequest) {
        userService.save(userRequest);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam String phone) {
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<UserResponse> findAll(@RequestParam Integer page,
                                              @RequestParam Integer size,
                                              @RequestParam String sortBy,
                                              @RequestParam Sort.Direction direction,
                                              @RequestParam(required = false) String secondName) {
        return userService.findAll(page, size, sortBy, direction, secondName);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        userService.delete(id);
        return HttpStatus.OK;
    }

}
