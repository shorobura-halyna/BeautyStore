package com.beautystore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalAmount;
    private LocalDate date;
    @ManyToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Commodity_Purchase", joinColumns = @JoinColumn(name = "id_purchase"), inverseJoinColumns = @JoinColumn(name = "id_commodity"))
    private List<Commodity> commodities = new ArrayList<>();
}
