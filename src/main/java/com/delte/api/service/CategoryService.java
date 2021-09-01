package com.delte.api.service;

import com.delte.api.mapper.CategoryDto;
import com.delte.api.model.Category;

import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
public interface CategoryService {
    Category save(Category category);
    List<CategoryDto> getAllCategory();
    CategoryDto getCategoryById(UUID categoryId);
    Boolean deleteById(UUID categoryId);
}
