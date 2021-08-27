package com.delte.api.repository;

import com.delte.api.mapper.CategoryDto;
import com.delte.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("select new com.delte.api.mapper.CategoryDto(c.categoryId,c.name) from Category c")
    List<CategoryDto> findAllCategory();
}
