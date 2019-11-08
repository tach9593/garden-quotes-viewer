package com.quotes.searchservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QuoteServiceErrorsAdvice {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ QuotesNotFoundException.class })
	public void handle(QuotesNotFoundException e) {
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ APIServiceException.class, NullPointerException.class })
	public void handle() {
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ QuotesServiceValidationException.class })
	public void handle(QuotesServiceValidationException e) {
	}
}
