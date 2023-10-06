package com.Natwest.project.budgeting.service;
import com.Natwest.project.budgeting.model.Budget;
import com.Natwest.project.budgeting.repository.BudgetRepository;
import com.Natwest.project.budgeting.model.Budget;
import com.Natwest.project.budgeting.model.Expense;
import com.Natwest.project.budgeting.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final BudgetRepository budgetRepository;

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, BudgetRepository budgetRepository) {
        this.expenseRepository = expenseRepository;
        this.budgetRepository = budgetRepository;
    }

    public Expense createExpense(Expense expense) {
       // Budget budget=new Budget();
//        System.out.println(budgetRepository.findById("651ee3efebc6ca4c4fbea4cf"));
        //Optional<Budget> existingBudget = budgetRepository.findByName("travel");
        //if (existingBudget.isPresent()) {
            return expenseRepository.save(expense);
        //}
       // throw new IllegalArgumentException("Expense creation failed. No existing budget found.");
   }



    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }


    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }

}