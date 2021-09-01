package com.delte.api.repository;

import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    @Query("select new com.delte.api.mapper.ExpenseDto(e.expenseId,e.expenseDate,e.category.categoryId,e.amount,e.category.name) from Expense e")
    List<ExpenseDto> findAllExpense();

    /*  @Query("select e from Expense e where SUBSTRING(e.expenseDate,1,7) = :expenseDate")*/
    List<Expense> findAllExpenseByExpenseDateBetween(Date startDate, Date expenseDate);

    @Query("select new com.delte.api.mapper.ExpenseDto(e.expenseId,e.expenseDate,e.category.categoryId,e.amount,e.category.name) from Expense e where e.expenseId = :expenseId")
    ExpenseDto findAllExpenseById(UUID expenseId);
}
