package com.delte.api.service.impl;

import com.delte.api.mapper.ExpenseCategoryDto;
import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Expense;
import com.delte.api.repository.CategoryRepository;
import com.delte.api.repository.ExpenseRepository;
import com.delte.api.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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

    @Override
    public List<ExpenseCategoryDto> getMonthyExpense() {
        List<Expense> expense = expenseRepository.findAllExpenseByExpenseDateBetween(getFirstDateOnMonth(), getLastDateOfMonth());

        double totalAmount = expense
                .stream()
                .mapToDouble(e -> e.getAmount())
                .sum();

        List<ExpenseCategoryDto> expenseCategoryDto = new ArrayList<>();

        expense.forEach(expe -> {
            ExpenseCategoryDto expenses = new ExpenseCategoryDto();
            expenses.setCategory(expe.getCategory().getName());
            expenses.setAmountCess(convertInTwoDigit(expe.getAmount() / totalAmount * 100));
            expenseCategoryDto.add(expenses);
        });

        return expenseCategoryDto;
    }

    @Override
    public Expense getExpenseById(UUID expenseId) {
        return expenseRepository.findById(expenseId).get();
    }

    private Date getLastDateOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    private Date getFirstDateOnMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    private double convertInTwoDigit(double number) {
        DecimalFormat dF = new DecimalFormat("###.##");
        return Double.valueOf(dF.format(number));
    }
}
