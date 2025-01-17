package com.savetravels.services;

import java.util.List;

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
	

}
