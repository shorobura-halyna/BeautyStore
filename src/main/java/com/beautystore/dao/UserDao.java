package com.beautystore.dao;

import com.beautystore.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    Page<User> findAllByLoginLike(String login, Pageable pageable);

    User findByLoginAndPassword(String login, String password);
}
