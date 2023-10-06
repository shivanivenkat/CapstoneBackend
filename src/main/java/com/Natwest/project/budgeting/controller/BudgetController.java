package com.Natwest.project.budgeting.controller;

import com.Natwest.project.budgeting.model.Budget;
import com.Natwest.project.budgeting.service.BudgetService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("/create")
    public Budget createBudget(@RequestBody Budget budget) {
        System.out.println(budget);
        return budgetService.createBudget(budget);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get/{id}")
    public Budget getBudget(@PathVariable String id) {
        return budgetService.getBudget(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/get/{name}")
   public Budget getBudgetByName(@PathVariable String name) {
       return budgetService.getBudgetByName(name);
   }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @PutMapping("/update/{id}")
    public void updateBudget(@PathVariable String id, @RequestBody Budget budget) {
        budgetService.updateBudget(budget);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBudget(@PathVariable String id) {
        budgetService.deleteBudget(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/calculate/{id}/breakdown")
    public BigDecimal calculateBudgetBreakdown(@PathVariable String id) {
        return budgetService.calculateBudgetBreakdown(budgetService.getBudget(id));
    }

   // @GetMapping("/budgets/{id}/alert")
    //public void sendBudgetAlert(@PathVariable String id) {
        //budgetService.sendBudgetAlert(budgetService.getBudget(id));
   // }
}
