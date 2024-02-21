package com.codegym.hue.manager_product_spring_boot.service.product.dto.req;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductReq(
        @NotBlank(message = "Tên sản phẩm không được để trống.")
        String name,
        @NotNull(message = "Giá sản phẩm không được để trống.")
        @Min(value = 1000, message = "Giá sản phẩm chỉ được trên hoặc bằng 1000 VNĐ.")
        BigDecimal price,
        @NotNull(message = "Tên hãng không được để trống. ")
        String company,
        @NotNull(message = "Thể loại sản phẩm không được để trống.")
        Long categoryId) {
}
