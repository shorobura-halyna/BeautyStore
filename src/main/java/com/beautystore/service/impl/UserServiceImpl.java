package com.beautystore.service.impl;

import com.beautystore.dao.UserDao;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.UserResponse;
import com.beautystore.model.User;
import com.beautystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserDao userDao;
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public DataResponse<UserResponse> findAll() {
        List<User> users = userDao.findAl;
        return users;
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }
}
