package com.delte.api.controller;

import com.delte.api.model.Expense;
import com.delte.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Expense> create(@RequestBody Expense expense) {
        return new ResponseEntity<>(expenseService.create(expense), HttpStatus.OK);
    }
}
