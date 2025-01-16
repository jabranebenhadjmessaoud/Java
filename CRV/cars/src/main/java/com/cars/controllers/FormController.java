package com.cars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class FormController {

	@GetMapping("/")
	public String index() {
		
		return "form.jsp";
	}
	@PostMapping("/processCar")
	public String processForm(@RequestParam ("make") String make, 
			@RequestParam ("model") String model,
			@RequestParam ("year") int year,
			@RequestParam ("color") String color ,
			HttpSession session,
			RedirectAttributes flash) {
		session.setAttribute("make", make);
		session.setAttribute("model", model);
		session.setAttribute("year", year);
		session.setAttribute("color", color);
		
		if (year<2000) {
			flash.addFlashAttribute("yearError","Car is too old");
			return "redirect:/";
		}
		flash.addFlashAttribute("success","Car Has been Successfully Created");
		
		return "redirect:/result";   
	}
	@GetMapping("/result")
	public String result() {
		return "result.jsp";	}
	
	
}
