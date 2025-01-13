package com.omikuji.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

public class FormController {

	@GetMapping("/")
	public String index0() {
		
		return "hello";
	}
	
	@GetMapping("/omikuji")
	public String index() {
		
		return "form.jsp";
	}  
	@PostMapping("/sendomi")
	public String processForm(
			@RequestParam ("number") int number,
			@RequestParam ("cityname") String cityname, 
			@RequestParam ("personname") String personname,
			@RequestParam ("hobby") String hobby ,
			@RequestParam ("livingthing") String livingthing ,
			@RequestParam ("somethingnice") String somethingnice ,
			HttpSession session,
			RedirectAttributes flash) {
		session.setAttribute("number", number);
		session.setAttribute("cityname", cityname);
		session.setAttribute("personname", personname);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingthing", livingthing);
		session.setAttribute("somethingnice", somethingnice);
		
		
		return "redirect:/omikuji/show";   
	}
	@GetMapping("/omikuji/show")
	public String result() {
		return "omikujishow.jsp";	}
	
	
}