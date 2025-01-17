package com.burgertrackerone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.burgertrackerone.models.Burger;
import com.burgertrackerone.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/burgers")
	public String index(Model model,@ModelAttribute("burger")Burger burger) {
		model.addAttribute("burgers",burgerService.getAllBurgers());
		return "index";
	}
	
	@PostMapping("/burger")
	public String create(@Valid @ModelAttribute("burger")Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burgers",burgerService.getAllBurgers());
			return "index";
		}
		burgerService.createBurger(burger);
		return "redirect:/burgers";
	}
	
	@GetMapping("/edit/{id}")
	public String update(@ModelAttribute("burger")Burger burger, Model model, @PathVariable("id")Long id) {
		Burger burgerEdit = burgerService.getBurgerById(id);
		model.addAttribute("burger",burgerEdit);
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String updateBurger(@PathVariable Long id, @Valid @ModelAttribute("burger")Burger burger, BindingResult result){
		if(result.hasErrors()) {
			return "edit";
		}
		burgerService.updateBurger(id, burger);
		return "redirect:/burgers";
	}
}
