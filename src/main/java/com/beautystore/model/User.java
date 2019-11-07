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
    private String firstName;
    private String secondName;
    private int age;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    @OneToOne(mappedBy = "user")
    private Basket basket;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Purchase> purchases = new ArrayList<>();

    public User (UserRequest userRequest){
        this.firstName = userRequest.getFirstName();
        this.secondName = userRequest.getSecondName();
        this.age = userRequest.getAge();
        this.phone = userRequest.getPhone();
        this.email = userRequest.getEmail();
        this.login = userRequest.getLogin();
        this.password = userRequest.getPassword();
    }

    public User(int id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
