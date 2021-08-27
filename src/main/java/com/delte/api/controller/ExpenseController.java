package com.delte.api.controller;

import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Expense;
import com.delte.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
@RestController
@RequestMapping("expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> create(@RequestBody ExpenseDto expense) {
        return new ResponseEntity<>(expenseService.create(expense), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }
}
