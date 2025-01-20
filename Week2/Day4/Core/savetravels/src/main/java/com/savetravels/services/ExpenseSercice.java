package com.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.savetravels.models.ExpenseModel;
import com.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseSercice {

@Autowired
ExpenseRepository expenseRepo;
// get all list expenses 
	public List<ExpenseModel> getAllExpenses(){
		return expenseRepo.findAll() ;   
	}
	
// add New Expense 
	public ExpenseModel addexpense(ExpenseModel expense) {
		return expenseRepo.save(expense);    
		}
// find by id 
	public ExpenseModel findById(Long id) {
		Optional<ExpenseModel> m=expenseRepo.findById(id);
		if (m.isPresent()) {
			return m.get();
			}
		return null ;
	}
// update expense
	public ExpenseModel updateExpense(ExpenseModel expense) {
		return expenseRepo.save(expense);
	}

// delete expense
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
		

}
