package com.delte.api.repository;

import com.delte.api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

}
