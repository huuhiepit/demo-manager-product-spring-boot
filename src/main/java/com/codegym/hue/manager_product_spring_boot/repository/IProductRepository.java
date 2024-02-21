package com.codegym.hue.manager_product_spring_boot.repository;

import com.codegym.hue.manager_product_spring_boot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
    boolean existsProductByNameContainingIgnoreCase(String name);
    Page<Product> findAllByNameContainingIgnoreCase(String search, Pageable pageable);
}
