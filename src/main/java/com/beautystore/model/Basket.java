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
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(name = "Basket_Commodity", joinColumns = @JoinColumn(name = "id_basket"), inverseJoinColumns = @JoinColumn(name = "id_commodity"))
    private List<Commodity> commodities = new ArrayList<>();
}
