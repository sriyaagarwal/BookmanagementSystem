package com.capg.bookmanagement.service;

import java.util.List;
import java.util.Optional;

import com.capg.bookmanagement.dto.BookDTO;

public interface BookService {

	public List<BookDTO> getAllBook();
     Optional<BookDTO> getBookById(String bookId); //return typre doubt
	BookDTO addBook(BookDTO books);
	BookDTO updateBookById(String bookId,BookDTO books);
	BookDTO deleteBookById(String bookId);

	
	
}
