package com.allbooks.controllers;
    
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allbooks.models.Book;
import com.allbooks.services.BookService;


@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}")
	public String onebook(Model model, @PathVariable("bookId") Long bookId) {
		
        model.addAttribute("book", bookService.findBook(bookId));
        return "show.jsp";  
	}
	@RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        System.out.println(books) ;
        return "index.jsp";
    }

}