package com.mxsaa7.expenseapi.expense;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public String home(){
        return "Welcome to our expense application";
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> expenseList(){
        List<Expense> expenses = expenseService.listAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/expenses/sum")
    public ResponseEntity<Integer> expenseSum(){
        int expenseSum = expenseService.getSum();
        return new ResponseEntity<>(expenseSum, HttpStatus.OK);
    }

    @GetMapping("/expense/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id){
        Expense expense = expenseService.get(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PostMapping("/expense/new")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        expenseService.add(expense);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @DeleteMapping("/expense/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        Expense expense = expenseService.get(id);
        expenseService.delete(id);
        return new ResponseEntity<>("Deleted: "  + expense.toString(), HttpStatus.OK);
    }

}
