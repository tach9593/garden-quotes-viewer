package com.quotes.searchservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class APIServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public APIServiceException(String message) {
		super(message);
	}
}
