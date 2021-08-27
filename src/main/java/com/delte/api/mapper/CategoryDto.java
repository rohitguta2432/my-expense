package com.delte.api.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 27/08/21
 **/

@Data
@AllArgsConstructor
public class CategoryDto {

    private UUID categoryId;
    private String name;

}
