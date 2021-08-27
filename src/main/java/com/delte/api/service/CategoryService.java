package com.delte.api.service;

import com.delte.api.model.Category;

import java.util.List;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
public interface CategoryService {
    Category save(Category category);
    List<Category> getAllCategory();
}
