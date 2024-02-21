package com.codegym.hue.manager_product_spring_boot.service.category;

import com.codegym.hue.manager_product_spring_boot.service.category.dto.req.CategoryReq;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.res.DetailCategoryRes;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.res.ListCategoryRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<ListCategoryRes> getListCategoryBySearchPage(String search, Pageable pageable);
    DetailCategoryRes getCategoryBy(Long id);
    DetailCategoryRes create(CategoryReq categoryReq);
    DetailCategoryRes update(Long id, CategoryReq categoryReq);
    void deleteBy(Long id);
}
