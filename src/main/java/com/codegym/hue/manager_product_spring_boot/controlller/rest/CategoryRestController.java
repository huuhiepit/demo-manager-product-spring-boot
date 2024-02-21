package com.codegym.hue.manager_product_spring_boot.controlller.rest;

import com.codegym.hue.manager_product_spring_boot.service.category.ICategoryService;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.req.CategoryReq;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.res.DetailCategoryRes;
import com.codegym.hue.manager_product_spring_boot.service.category.dto.res.ListCategoryRes;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryRestController {
    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<ListCategoryRes>> index(
                                        @RequestParam(defaultValue = "", required = false) String search,
                                        @PageableDefault(sort = "name", direction = Sort.Direction.DESC, page = 0, size = 5) Pageable pageable) {
        return ResponseEntity.ok(categoryService.getListCategoryBySearchPage(search, pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetailCategoryRes> detailCategory(@RequestParam Long id) {
        return ResponseEntity.ok(categoryService.getCategoryBy(id));
    }
    @PostMapping
    public ResponseEntity<DetailCategoryRes> create(@RequestBody CategoryReq categoryReq) {
        return ResponseEntity.ok(categoryService.create(categoryReq));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetailCategoryRes> update(@PathVariable Long id, @RequestBody CategoryReq categoryReq) {
        return ResponseEntity.ok(categoryService.update(id, categoryReq));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.deleteBy(id);
        return ResponseEntity.ok().build();
    }
}
