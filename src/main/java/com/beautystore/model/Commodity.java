package com.beautystore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private int price;
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Subcategory subcategory;
    private String urlToPicture;
    @ManyToMany
    @JoinTable(name = "Basket_Commodity", joinColumns = @JoinColumn(name = "id_commodity"), inverseJoinColumns = @JoinColumn(name = "id_basket"))
    private List<Basket> baskets = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Commodity_Purchase", joinColumns = @JoinColumn(name = "id_commodity"), inverseJoinColumns = @JoinColumn(name = "id_purchase"))
    private List<Purchase> purchases = new ArrayList<>();

    public Commodity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Commodity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
