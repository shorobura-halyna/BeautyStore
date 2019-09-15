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
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Subcategory subcategory;
    @ManyToMany
    @JoinTable(name = "Basket_Commodity", joinColumns = @JoinColumn(name = "id_commodity"), inverseJoinColumns = @JoinColumn (name = "id_basket"))
    private List<Basket> baskets = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Commodity_Purchase", joinColumns = @JoinColumn(name = "id_commodity"), inverseJoinColumns = @JoinColumn(name = "id_purchase"))
    private List<Purchase> purchases = new ArrayList<>();



}
