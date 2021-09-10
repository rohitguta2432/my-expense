package com.delte.api.controller;

import com.delte.api.mapper.CategoryDto;
import com.delte.api.model.Category;
import com.delte.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return new ResponseEntity(categoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable UUID categoryId) {
        return new ResponseEntity(categoryService.getCategoryById(categoryId), HttpStatus.OK);
    }
    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable UUID categoryId){
            return new ResponseEntity<>(categoryService.deleteById(categoryId), HttpStatus.OK);
    }
}
