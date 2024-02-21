package com.codegym.hue.manager_product_spring_boot.service.category;

import com.codegym.hue.manager_product_spring_boot.model.Category;
import com.codegym.hue.manager_product_spring_boot.repository.ICategoryRepository;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.req.CategoryReq;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.res.DetailCategoryRes;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.res.ListCategoryRes;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService{
    private final ICategoryRepository categoryRepository;

    @Override
    public Page<ListCategoryRes> getListCategoryBySearchPage(String search, Pageable pageable) {
        return categoryRepository.findAllByNameContainingIgnoreCase(search, pageable).map(category -> new ListCategoryRes(category.getId(), category.getName()));
    }

    @Override
    public DetailCategoryRes getCategoryBy(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy được thể loại."))
                .toCategoryRes();
    }

    @Override
    public DetailCategoryRes create(CategoryReq categoryReq) {
        Category category = new Category();
        category.setName(categoryReq.name());
        return categoryRepository.save(category).toCategoryRes();
    }

    @Override
    public DetailCategoryRes update(Long id, CategoryReq categoryReq) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy được thể loại muốn sửa"));
        category.setName(categoryReq.name());
        return categoryRepository.save(category).toCategoryRes();
    }

    @Override
    public void deleteBy(Long id) {
        categoryRepository.deleteById(id);
    }
}
