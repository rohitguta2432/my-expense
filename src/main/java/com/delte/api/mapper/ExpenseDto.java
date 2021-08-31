package com.delte.api.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 27/08/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {
    private UUID expenseId;
    private Date expenseDate;
    private UUID categoryId;
    private double amount;
    private String name;
}
