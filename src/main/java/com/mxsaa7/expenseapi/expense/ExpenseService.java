package com.mxsaa7.expenseapi.expense;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ExpenseService {

    //TODO: Add a service to query expenses by date - expenses on this date, expenses between dates.
    private ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> listAll(){
        return expenseRepository.findAll();
    }

    public Expense add(Expense expense){
       return expenseRepository.save(expense);
    }

    public Expense get(long id){
        return expenseRepository.findById(id).get();
    }

    public void delete(long id){
        expenseRepository.deleteById(id);
    }

    public int getSum(){
        List<Expense> expenses = expenseRepository.findAll();
        int expenseSum = 0;
        for(Expense expense : expenses){
            expenseSum += expense.getAmount();
        }
        return expenseSum;
    }

}
