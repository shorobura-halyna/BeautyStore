package com.beautystore.service.impl;

import com.beautystore.dao.UserDao;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.model.User;
import com.beautystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public DataResponse<UserResponse> findAll(Integer page,
                                              Integer size,
                                              String sortBy,
                                              Sort.Direction direction,
                                              String secondName) {
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<User> userPage;
        if (secondName != null) {
            userPage = userDao.findAllBySecondNameLike("%" + secondName + "%", pageRequest);
        } else {
            userPage = userDao.findAll(pageRequest);
        }
        return new DataResponse<>(userPage.getContent().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList()), userPage);
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }
}
