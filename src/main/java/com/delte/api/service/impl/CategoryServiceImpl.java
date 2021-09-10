package com.delte.api.service.impl;

import com.delte.api.mapper.CategoryDto;
import com.delte.api.model.Category;
import com.delte.api.repository.CategoryRepository;
import com.delte.api.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        log.info("fetch all Category : {}");
        return categoryRepository.findAllCategory();
    }

    @Override
    public CategoryDto getCategoryById(UUID categoryId) {
        log.info("fetching category by id : {} ", categoryId);
        return categoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public Boolean deleteById(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }
}
