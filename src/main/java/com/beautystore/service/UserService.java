package com.beautystore.service;

import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(User user);

    DataResponse<UserResponse> findAll(Integer page,
                                       Integer size,
                                       String sortBy,
                                       Sort.Direction direction,
                                       String secondName);

    void delete(int id);
}
