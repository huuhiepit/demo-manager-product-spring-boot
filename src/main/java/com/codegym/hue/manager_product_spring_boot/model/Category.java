package com.codegym.hue.manager_product_spring_boot.model;

import com.codegym.hue.manager_product_spring_boot.service.category.dto.req.CategoryReq;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.res.DetailCategoryRes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "categories")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    public DetailCategoryRes toCategoryRes() {
        return new DetailCategoryRes(this.getId(), this.getName());
    }
}
