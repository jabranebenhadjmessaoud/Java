package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.Book;
import com.bookclub.repositories.BookRepository;
import com.bookclub.repositories.UserRepository;


@Service
public class BookService {
	@Autowired
	BookRepository bookRepo ;
	@Autowired
	UserRepository userRepo ;
	
	//get all books 
	public List<Book> getAllBooks(){
		return bookRepo.findAll() ;
	}
	
	// Add one book
	public Book addbook(Book book) {
		return bookRepo.save(book) ;
	}
	
	// get one book by id 
	public Book findById(Long id) {
		Optional<Book> b=bookRepo.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		return null;
	}
	
	// update
	public Book updateBook(Long id,Book book) {
		// we will set the id to the book
		book.setId(id);
		// we will save using bookRepo
		return	bookRepo.save(book);
	}
	
	// Delete song 
		public void deleteBook(Long id) {
			//get the song with id 
			Book book=findById(id);
			//we will set the creator to null 
			book.setCreator(null);
			// we will delete the book now 
			bookRepo.deleteById(id);
		}
	
	

}
