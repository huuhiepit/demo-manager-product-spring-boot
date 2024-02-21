package com.codegym.hue.manager_product_spring_boot.service.category.dto.req;

import jakarta.validation.constraints.NotBlank;

public record CategoryReq(
        @NotBlank(message = "Tên loại sản phẩm không được để trống.")
        String name) {
}
