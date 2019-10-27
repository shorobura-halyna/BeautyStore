package com.beautystore.dao;

import com.beautystore.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    Page<User> findAllBySecondNameLike(String secondName, Pageable pageable);

}
