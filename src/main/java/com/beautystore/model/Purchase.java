package com.beautystore.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalAmount;
    private LocalDateTime date;
    @ManyToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Commodity_Purchase", joinColumns = @JoinColumn(name = "id_purchase"), inverseJoinColumns = @JoinColumn(name = "id_commodity"))
    private List<Commodity> commodities = new ArrayList<>();

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
