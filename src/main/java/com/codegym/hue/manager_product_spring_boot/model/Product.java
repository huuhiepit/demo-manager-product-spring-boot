package com.codegym.hue.manager_product_spring_boot.model;

import com.codegym.hue.manager_product_spring_boot.model.enumeration.ECompany;
import com.codegym.hue.manager_product_spring_boot.service.product.dto.res.ProductRes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ECompany company;

    @ManyToOne
    private Category category;

    public ProductRes toProductRes() {
        return new ProductRes(this.id, this.name, this.price, this.company.toCustomString(), this.category.getName());
    }
}
