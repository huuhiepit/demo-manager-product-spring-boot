package com.codegym.hue.manager_product_spring_boot.controlller.rest;

import com.codegym.hue.manager_product_spring_boot.service.product.IProductService;
import com.codegym.hue.manager_product_spring_boot.service.product.dto.req.ProductReq;
import com.codegym.hue.manager_product_spring_boot.service.product.dto.res.ProductRes;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductRestController {
    private final IProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductRes>> index(@RequestParam(defaultValue = "") String search,
                                                  @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 5)Pageable page) {
        return ResponseEntity.ok(productService.getAllProductBySearch(search, page));
    }
    @PostMapping
    public ResponseEntity<ProductRes> create(@RequestBody ProductReq productReq) {
        return ResponseEntity.ok(productService.createProduct(productReq));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductRes> update(@PathVariable Long id, @RequestBody ProductReq productReq) {
        return ResponseEntity.ok(productService.updateProduct(id, productReq));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteProductBy(id);
        return ResponseEntity.ok().build();
    }
}
