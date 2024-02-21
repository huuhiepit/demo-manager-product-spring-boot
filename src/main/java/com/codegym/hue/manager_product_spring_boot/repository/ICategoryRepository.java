package com.codegym.hue.manager_product_spring_boot.repository;

import com.codegym.hue.manager_product_spring_boot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByNameContainingIgnoreCase(String search, Pageable pageable);
}
