package com.capg.bookmanagement.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.bookmanagement.dto.BookDTO;

import com.capg.bookmanagement.exception.BookNotFoundException;
import com.capg.bookmanagement.exception.EmptyBookListException;

import com.capg.bookmanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookDTO> getAllBook() {
		if(bookRepository.count()==0)
		{
			throw new EmptyBookListException("No book exists in the database");
		}
		return bookRepository.findAll();
	}

	@Override
	public Optional<BookDTO> getBookById(String bookId) {
		if (!bookRepository.existsById(bookId)) {
			throw new BookNotFoundException("Book with Id " + bookId + " Not Found");
		}
		return bookRepository.findById(bookId);
	}

	@Override
	public BookDTO addBook(BookDTO books)  {
		String bookId = "BOOK" + bookRepository.count();
		books.setBookId(bookId);
		return bookRepository.save(books);

	}

	@Override
	public BookDTO updateBookById(String bookId, BookDTO books) {

		if (!bookRepository.existsById(books.getBookId())) {
			throw new BookNotFoundException("Book with Id : " + books.getBookId() + " Not Found");
		}
		BookDTO newBook = bookRepository.getOne(books.getBookId());
		return bookRepository.save(newBook);
	}

	@Override
	public BookDTO deleteBookById(String bookId) {
		if (!bookRepository.existsById(bookId)) {
			throw new BookNotFoundException("Book with Id " + bookId + " Not Found");
		}
		BookDTO books=bookRepository.findById(bookId).get();
		bookRepository.delete(books);
		return books;

	}

}
