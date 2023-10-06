package com.Natwest.project.budgeting.service;

import com.Natwest.project.budgeting.model.Budget;
import com.Natwest.project.budgeting.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget createBudget(Budget budget) {
        System.out.println(budget);
        return budgetRepository.save(budget);

    }

    public Budget getBudget(String id) {
        return budgetRepository.findById(id).orElse(null);
    }
    public Budget getBudgetByName(String name) {
        return budgetRepository.findByName(name).orElse(null);
    }
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public void updateBudget(Budget budget) {
        Optional<Budget> existingBudget = budgetRepository.findById(budget.getId());
        if (existingBudget.isPresent()) {
            Budget budgetToUpdate = existingBudget.get();

            // Update budget fields with the values from updatedBudget
            budgetToUpdate.setName(budget.getName());
            budgetToUpdate.setExpenses(budget.getExpenses());
            budgetToUpdate.setMaximumExpense(budget.getMaximumExpense());
            budgetRepository.save(budgetToUpdate);



        }
//        budgetRepository.save(budget);
    }
    

    public void deleteBudget(String id) {
        budgetRepository.deleteById(id);
    }

    public BigDecimal calculateBudgetBreakdown(Budget budget) {
        return budget.getMaximumExpense().subtract(budget.getExpenses());
    }

//    public boolean isExceedingBudget(Budget budget) {
//        return budget.getExpenses().compareTo(budget.getBudget()) > 0;
//
//    }

//    public void sendBudgetAlert(Budget budget) {
//        // TODO: ALERT TO USER
//    }
}
