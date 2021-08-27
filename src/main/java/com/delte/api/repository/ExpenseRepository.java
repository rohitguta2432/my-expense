package com.delte.api.repository;

import com.delte.api.mapper.ExpenseDto;
import com.delte.api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    @Query("select new com.delte.api.mapper.ExpenseDto(e.expenseDate,e.category.categoryId,e.amount) from Expense e")
    List<ExpenseDto> findAllExpense();
}
