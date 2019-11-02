package com.beautystore.service;

import com.beautystore.dto.request.filter.FilterUserRequest;
import com.beautystore.dto.request.UserRequest;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void save(UserRequest userRequest);

    void save(User user);

    DataResponse<UserResponse> findAll(Integer page,
                                       Integer size,
                                       String sortBy,
                                       Sort.Direction direction,
                                       String secondName);

    void delete(int id);

    List<UserResponse> filter(FilterUserRequest filterUserRequest);
}
