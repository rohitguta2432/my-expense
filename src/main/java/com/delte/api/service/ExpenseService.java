package com.delte.api.service;

import com.delte.api.mapper.ExpenseCategoryDto;
import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Expense;

import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
public interface ExpenseService {
    Expense create(ExpenseDto expense);
    List<ExpenseDto> getAllExpenses();
    List<ExpenseCategoryDto> getMonthyExpense();
    ExpenseDto getExpenseById(UUID expenseId);

}
