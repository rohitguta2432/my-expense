package com.delte.api.service.impl;

import com.delte.api.model.Expense;
import com.delte.api.repository.ExpenseRepository;
import com.delte.api.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author rohit
 * @Date 09/08/21
 **/

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense create(Expense expense) {
        return expenseRepository.save(expense);
    }

}
