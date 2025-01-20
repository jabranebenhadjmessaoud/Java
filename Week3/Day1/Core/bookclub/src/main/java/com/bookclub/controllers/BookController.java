package com.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bookclub.models.Book;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class BookController {

	@Autowired
	BookService bookserv ;
	@Autowired
	UserService userServ ;

	//get create page 
	@GetMapping("/addbook")
	public String create(@ModelAttribute("book") Book book,HttpSession session ) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		return "createbook";
	}
	
	// post create song 
	@PostMapping("/addbook")
	public String create(@Valid @ModelAttribute("book")Book book,
				         BindingResult result,
				          HttpSession session) {
			
	// if there is validation errors 
		if(result.hasErrors()) {
		return "createbook";
		}
		// we will get the connected user
		User connectedUser = userServ.findById((Long) session.getAttribute("userId"));
		//set the creator of the song 
		book.setCreator(connectedUser);
		System.out.println(connectedUser);
		System.out.println(book);
		//else we will create the song 
		bookserv.addbook(book);
		return "redirect:/books";
			
		}
	// display a book 
	@GetMapping("/display/{bookId}")
    public String displayBook(@PathVariable("bookId")Long bookId,
    							Model model,
    							HttpSession session) {    
		User user = userServ.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		// get the song by id 
		Book book =bookserv.findById(bookId);
		model.addAttribute("book",book);
		return "displaybook";
	}
	
	// GetEdit page 
	@GetMapping("/edit/{bookId}")
	public String getEditPage(@PathVariable("bookId")Long bookId,
					          Model model) {
				
		// we will get the song using the id 
		Book book=bookserv.findById(bookId);
		//set the song to the model attribute 
		model.addAttribute("book",book);
		System.out.print("From get edit page"+book.getCreator());
		//return edit page
		return "editbook";
		}
	
	// Post Edit
	@PutMapping("/edit/{bookId}")
	public String editSong(@Valid @ModelAttribute("book")Book book,
							BindingResult result,
					       @PathVariable("bookId")Long bookId,
					      HttpSession session) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "edit";
		}	   
		System.out.print(book.getCreator());
		book.setCreator(userServ.findById((Long) session.getAttribute("userId")));
		bookserv.updateBook(bookId, book);
		return "redirect:/books";
				
		}
	
	// delete a Book
		@GetMapping("/delete/{bookId}")
		public String deleteBook(@PathVariable("bookId") Long bookId) {
			bookserv.deleteBook(bookId);
			return "redirect:/books";
		}
	      
}
