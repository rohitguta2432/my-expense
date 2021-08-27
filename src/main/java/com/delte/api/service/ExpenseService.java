package com.delte.api.service;

import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Expense;

import java.util.List;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
public interface ExpenseService {
    Expense create(ExpenseDto expense);
    List<ExpenseDto> getAllExpenses();
}
