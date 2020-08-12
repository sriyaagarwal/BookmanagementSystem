package com.capg.bookmanagement.exception;



@SuppressWarnings("serial")
public class BookAlreadyExistException extends RuntimeException {

	public BookAlreadyExistException(String message) {
		super(message);
	}

	

}
