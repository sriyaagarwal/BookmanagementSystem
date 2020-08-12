package com.capg.bookmanagement.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.capg.bookmanagement.dto.BookDTO;
import com.capg.bookmanagement.exception.NullParameterException;

import com.capg.bookmanagement.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bookmanagement")
public class BookController {

	private static final Logger logger =LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService bookservice;

	@ApiOperation(value="Get all the available books",
			notes="This api end points is to view all the books",
			response= BookDTO.class)
	@GetMapping("/getallbooks")
	public List<BookDTO> getAllBook() {
		return this.bookservice.getAllBook();
	}

	@ApiOperation(value="Get the  books by the id given as parameter",
			notes=" This api end points is to view a single book by id",
			response= BookDTO.class)
	@GetMapping("/getBookbyId/{id}")
	public Optional<BookDTO> getBookById(@PathVariable("id") String bookId)  {
		if(bookId==null) {
			logger.error("Null request,  Id not provided for  /getBookById");
			throw new NullParameterException("Null request, please provide Id to see the books!");
		}

		return this.bookservice.getBookById(bookId);

	}

	@ApiOperation(
			value = "Add books to Website",
			notes = "Admin can add book to Website with this API",
			response = String.class
			)
	@PostMapping("/addBook")
	public String addBook(@RequestBody BookDTO books) {
		if(books==null || books.getAuthor().trim().length() == 0 ||
				books.getTitle().trim().length() == 0) { 
			logger.error("Null request,book details not provided at /addBook");
			throw new NullParameterException("Null request, please provide book details to add it in database");
		}
		String status = "Book added";
		bookservice.addBook(books) ;
		return status;
	}

	@ApiOperation(value="To update a book in the website",
			notes="This api end points should update  a existing book in the website"
					+ "This api can only be accesed by the Admin of the "
					+ "BookStore Management System ",
					response= String.class)
	@RequestMapping(method = RequestMethod.PUT, value = "/updateBookById/{id}")
	public String updateBookById(@RequestBody BookDTO books, @PathVariable("id") String bookId)  {

		if(bookId==null || books==null|| books.getAuthor().trim().length()==0 ) {
			logger.error("Null request,  Id not provided for  /updateBookById");
			throw new NullParameterException("Null request, please provide inputs to update the books details!");
		}
		String status = "Book updated";
		bookservice.updateBookById(bookId, books); 
		return status;
	}

	@ApiOperation(value="To delete a book from the website",
			notes="This api end points should delete a existing book in the website"
					+ "This api can only be accesed by the Admin of the "
					+ "BookStore Management System ",
					response= String.class)
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteBookById/{id}")
	public String deleteBookById(@PathVariable("id") String bookId)  {

		if(bookId==null) {
			logger.error("Null request,  Id not provided for  /deleteBookById");
			throw new NullParameterException("Null request, please provide Id to delete the book!");
		}
		String status = "Book deleted";
		bookservice.deleteBookById(bookId);
		return status;
	}
	

}
	

	
	  
	
	
