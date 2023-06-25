package com.mxsaa7.expenseapi.expense;

import com.mxsaa7.expenseapi.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {



}
