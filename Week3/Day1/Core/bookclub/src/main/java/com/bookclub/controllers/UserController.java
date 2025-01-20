package com.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	BookService bookserv ;
	
	//get the index page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newLogin",new LoginUser());
		model.addAttribute("newUser",new User());
		return "index";
	}
	
	//Register
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			             BindingResult result,
			             HttpSession session,
			             Model model) {
	User user = userService.register(newUser, result);
		
	    if(result.hasErrors()) {
	        //  send in the empty LoginUser before re-rendering the page.
	        model.addAttribute("newLogin", new LoginUser());
	        return "index";
	    }
	    
	    session.setAttribute("userId", user.getId());
	    session.setAttribute("connectedUser", user);
	    return "redirect:/books";
		
	}
	
	//login
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,
			 BindingResult result,
	         HttpSession session,
	         Model model) {
		User user = userService.login(newLogin, result);
		 
	    if(result.hasErrors() || user==null) {
	    	//set the new user to empty and redirect to index
	        model.addAttribute("newUser", new User());
	        return "index";
	    }
	     //redirect to home page
	    session.setAttribute("userId", user.getId());
	    session.setAttribute("connectedUser", user);
	 
	    return "redirect:/books";
	}
	
	
	//home display
	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		User user = userService.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		model.addAttribute("books",bookserv.getAllBooks());
		return "home";
	}
	
	//Logout 
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			//clear session
			session.invalidate();
			//redirect
			return "redirect:/";
		}
}
