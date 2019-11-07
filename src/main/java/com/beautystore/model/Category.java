package com.beautystore.model;

import com.beautystore.dto.request.CategoryRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories = new ArrayList<>();

    public Category(CategoryRequest categoryRequest) {
        this.name = categoryRequest.getName();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
