package com.beautystore.model;

import com.beautystore.dto.request.BrandRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<Commodity> commodities = new ArrayList<>();

    public Brand(BrandRequest brandRequest) {
        this.name = brandRequest.getName();
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
