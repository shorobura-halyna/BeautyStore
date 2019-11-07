package com.beautystore.model;

import com.beautystore.dto.request.CommodityRequest;
import lombok.*;

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
    @ManyToMany
    @JoinTable(name = "Basket_Commodity", joinColumns = @JoinColumn(name = "id_commodity"), inverseJoinColumns = @JoinColumn(name = "id_basket"))
    private List<Basket> baskets = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Commodity_Purchase", joinColumns = @JoinColumn(name = "id_commodity"), inverseJoinColumns = @JoinColumn(name = "id_purchase"))
    private List<Purchase> purchases = new ArrayList<>();

    public Commodity(CommodityRequest commodityRequest, Brand brand, Subcategory subcategory) {
        this.name = commodityRequest.getName();
        this.price = commodityRequest.getPrice();
        this.brand = brand;
        this.subcategory = subcategory;
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
