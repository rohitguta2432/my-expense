package com.delte.api.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 27/08/21
 **/
@Data
@AllArgsConstructor
public class ExpenseDto {
    private Date expenseDate;
    private UUID categoryId;
    private double amount;
}
