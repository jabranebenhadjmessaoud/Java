package com.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.savetravels.models.ExpenseModel;
import com.savetravels.services.ExpenseSercice;

import jakarta.validation.Valid;



@Controller
public class ExpenseController {
	@Autowired
	ExpenseSercice expservice;
    // get home page 
	@GetMapping("/")
	public String home(@ModelAttribute ("expense") ExpenseModel expense  ,Model model) {
		model.addAttribute("expenses",expservice.getAllExpenses());
		model.addAttribute("newexpense", new ExpenseModel());
		return "homepage";
	}
	
	// add new expense
	@PostMapping("/addexpense")
	public String addnew(@Valid @ModelAttribute ("expense") ExpenseModel expense,
			BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses",expservice.getAllExpenses());
			model.addAttribute("newexpense", new ExpenseModel());
			return "homepage";
			}
		expservice.addexpense(expense) ;
		return "redirect:/";    
		}
	
	
	// get edit page 
	@GetMapping("/edit/{id}")
	public String renderEditPage(@ModelAttribute("expense")ExpenseModel expense,Model model,@PathVariable("id")Long id) {
		ExpenseModel exp=expservice.findById(id);
		model.addAttribute("expense",exp);
		return "editexp";
	}
	// put the edit 
	@PutMapping("/edit/{id}") 
	public String updateexpense(@PathVariable Long id, @Valid @ModelAttribute("expense")ExpenseModel expense, BindingResult result)
	{ if (result.hasErrors()) {
		return "editexp"; 

	 }     
	expservice.updateExpense(expense);

	return "redirect:/"; }
	
	@GetMapping("/delete/{id}")
	public String deleteExp(@PathVariable("id")Long id) {
		expservice.deleteExpense(id);
		return "redirect:/";
	}
	@GetMapping("/view/{id}")
	public String viewOne(@ModelAttribute("expense")ExpenseModel expense,Model model,@PathVariable("id")Long id) {
		ExpenseModel exp=expservice.findById(id);
		model.addAttribute("expense",exp);
		return "viewone";
	}
	

	
	}
	

	

