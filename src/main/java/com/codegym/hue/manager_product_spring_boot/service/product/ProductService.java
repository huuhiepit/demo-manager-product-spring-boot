package com.codegym.hue.manager_product_spring_boot.service.product;

import com.codegym.hue.manager_product_spring_boot.model.Product;
import com.codegym.hue.manager_product_spring_boot.model.enumeration.ECompany;
import com.codegym.hue.manager_product_spring_boot.repository.ICategoryRepository;
import com.codegym.hue.manager_product_spring_boot.repository.IProductRepository;
import com.codegym.hue.manager_product_spring_boot.service.product.dto.req.ProductReq;
import com.codegym.hue.manager_product_spring_boot.service.product.dto.res.ProductRes;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public Page<ProductRes> getAllProductBySearch(String search, Pageable pageable) {
        return productRepository.findAllByNameContainingIgnoreCase(search, pageable).map(Product::toProductRes);
    }
    @Override
    public ProductRes getDetailProductBy(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm.")).toProductRes();
    }
    @Override
    public boolean exitNameProduct(String name) {
        return productRepository.existsProductByNameContainingIgnoreCase(name);
    }
    @Override
    public ProductRes createProduct(ProductReq productReq) {
        if(!exitNameProduct(productReq.name())) {
            return getProductRes(productReq, new Product());
        }
        throw new IllegalArgumentException("Sản phẩm đã tồn tại.");
    }
    @Override
    public ProductRes updateProduct(Long id, ProductReq productReq) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm."));
        if(product.getName().equals(productReq.name())) {
            return product.toProductRes();
        }
        if(!exitNameProduct(productReq.name())) {
            throw new IllegalArgumentException("Sản phẩm đã tồn tại.");
        }
        return getProductRes(productReq, product);
    }

    private ProductRes getProductRes(ProductReq productReq, Product product) {
        product.setName(productReq.name());
        product.setPrice(productReq.price());
        product.setCategory(categoryRepository.findById(productReq.categoryId()).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm.")));
        product.setCompany(ECompany.valueOf(productReq.company()));
        return productRepository.save(product).toProductRes();
    }

    @Override
    public void deleteProductBy(Long id) {
        productRepository.deleteById(id);
    }
}
