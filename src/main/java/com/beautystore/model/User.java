package com.beautystore.model;

import com.beautystore.dto.request.UserRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    @Enumerated
    private Role role;
    @OneToOne(mappedBy = "user")
    private Basket basket = new Basket();
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Purchase> purchases = new ArrayList<>();

    public User(UserRequest userRequest) {
        this.email = userRequest.getEmail();
        this.login = userRequest.getLogin();
        this.password = userRequest.getPassword();
    }

    public User(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public enum Role {
        ADMIN, USER
    }
}
