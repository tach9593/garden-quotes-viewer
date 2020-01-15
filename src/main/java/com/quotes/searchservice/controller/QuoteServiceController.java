package com.quotes.searchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quotes.searchservice.model.Quote;
import com.quotes.searchservice.service.QuoteService;

@RestController
@CrossOrigin(origins = "#{environment.angularClientUrl}")
public class QuoteServiceController {

	@Autowired
	public QuoteService quoteService;
	
	/**
	 * Returns a list of quotes using a search term.
	 * @param term
	 * @return Quote array
	 */
	@GetMapping("/quotes/{term}")
	public Quote[] quotes(@PathVariable String term)
    {
	   return quoteService.getQuotes(term);
	}
} 