package com.delte.api.service.impl;

import com.delte.api.mapper.ExpenseCategoryDto;
import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Category;
import com.delte.api.model.Expense;
import com.delte.api.repository.CategoryRepository;
import com.delte.api.repository.ExpenseRepository;
import com.delte.api.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        log.info("create expense : {} ", expenses);

        Optional<Expense> expensese = Optional.empty();
        Expense expense = new Expense();
        if (!ObjectUtils.isEmpty(expenses.getExpenseId())) {
            expensese = expenseRepository.findById(expenses.getExpenseId());
            if (expensese.isPresent()) {
                expensese.get().setExpenseDate(expenses.getExpenseDate());
                expensese.get().setAmount(expenses.getAmount());
                expensese.get().setCategory(categoryRepository
                        .findById(expenses.getCategoryId()).get());
                expenseRepository.save(expensese.get());
            }
        } else {
            expense.setExpenseDate(expenses.getExpenseDate());
            expense.setAmount(expenses.getAmount());
            expense.setCategory(categoryRepository
                    .findById(expenses.getCategoryId()).get());

            expenseRepository.save(expense);
        }
        return !ObjectUtils.isEmpty(expenses.getExpenseId()) ? expensese.get() : expense;
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

        Map<String, DoubleSummaryStatistics> map = expense.stream()
                .collect(Collectors.groupingBy(e -> e.getCategory().getName(), Collectors.summarizingDouble(Expense::getAmount)));

        map.forEach((category, value) -> {
            ExpenseCategoryDto expenses = new ExpenseCategoryDto();
            expenses.setLabel(category);
            expenses.setY(convertInTwoDigit(value.getSum() / totalAmount * 100));
            expenseCategoryDto.add(expenses);
        });

       /* expense.forEach(expe -> {
            if (!ObjectUtils.isEmpty(expe.getCategory())) {
                ExpenseCategoryDto expenses = new ExpenseCategoryDto();
                expenses.setLabel(expe.getCategory().getName());
                expenses.setY(convertInTwoDigit(expe.getAmount() / totalAmount * 100));
                expenseCategoryDto.add(expenses);
            }
        });*/

        return expenseCategoryDto;
    }

    private String getName(Category category) {
        return category.getName();
    }

    @Override
    public ExpenseDto getExpenseById(UUID expenseId) {
        return expenseRepository.findAllExpenseById(expenseId);
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
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        return calendar.getTime();
    }

    private double convertInTwoDigit(double number) {
        DecimalFormat dF = new DecimalFormat("###.##");
        return Double.valueOf(dF.format(number));
    }
}
