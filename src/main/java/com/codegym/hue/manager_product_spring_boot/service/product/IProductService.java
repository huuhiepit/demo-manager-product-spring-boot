package com.codegym.hue.manager_product_spring_boot.service.product;

import com.codegym.hue.manager_product_spring_boot.service.product.dto.req.ProductReq;
import com.codegym.hue.manager_product_spring_boot.service.product.dto.res.ProductRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductRes> getAllProductBySearch(String search, Pageable pageable);
    ProductRes getDetailProductBy(Long id);
    boolean exitNameProduct(String name);
    ProductRes createProduct(ProductReq productReq);
    ProductRes updateProduct(Long id, ProductReq productReq);
    void deleteProductBy(Long id);
}
