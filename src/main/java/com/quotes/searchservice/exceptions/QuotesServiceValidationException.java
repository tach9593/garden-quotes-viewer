package com.quotes.searchservice.exceptions;

public class QuotesServiceValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QuotesServiceValidationException(String message) {
		super(message);
	}
}
