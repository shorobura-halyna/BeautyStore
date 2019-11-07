package com.beautystore.model;

import com.beautystore.dto.request.SubcategoryRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "subcategory")
    private List<Commodity> commodities = new ArrayList<>();

    public Subcategory(SubcategoryRequest subcategoryRequest, Category category) {
        this.name = subcategoryRequest.getName();
        this.category = category;
    }
    public Subcategory(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Subcategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
