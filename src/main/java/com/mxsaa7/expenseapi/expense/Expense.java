package com.mxsaa7.expenseapi.expense;

import jakarta.persistence.*;
import jdk.jfr.Category;
@Entity
public class Expense {

    //TODO: Add a date field/attribute to expense object
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;
    private double amount;

    public Expense(){}

    public Expense(String name, ExpenseCategory expenseCategory, double amount) {
        this.name = name;
        this.expenseCategory = expenseCategory;
        this.amount = amount;
    }

    public Long getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpenseCategory getCategory(){return expenseCategory; }

    public void setCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "Expense \n{" +
                "\nid: " + id +
                ",\n name: " + name +
                ",\n amount: $" + amount +
                ",\n category: " + expenseCategory +
                "\n}";
    }
}
