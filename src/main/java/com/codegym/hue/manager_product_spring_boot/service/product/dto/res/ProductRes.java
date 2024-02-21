package com.codegym.hue.manager_product_spring_boot.service.product.dto.res;

import java.math.BigDecimal;

public record ProductRes(
        Long id,
        String name,
        BigDecimal price,
        String company,
        String category) {
}
