package com.beautystore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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
    private int phone;
    private String email;
    @OneToOne (mappedBy = "user")
    private Basket basket;
    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases = new ArrayList<>();
}
