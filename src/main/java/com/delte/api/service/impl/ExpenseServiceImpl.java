package com.delte.api.service.impl;

import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Expense;
import com.delte.api.repository.CategoryRepository;
import com.delte.api.repository.ExpenseRepository;
import com.delte.api.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rohit
 * @Date 09/08/21
 **/

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Expense create(ExpenseDto expenses) {
        Expense expense = new Expense();
            expense.setExpenseDate(expenses.getExpenseDate());
            expense.setAmount(expenses.getAmount());
            expense.setCategory(categoryRepository
                    .findById(expenses.getCategoryId()).get());
            expenseRepository.save(expense);
        return expense;
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        log.info("fetch all expenses : {} ");
        return expenseRepository.findAllExpense();
    }

}
