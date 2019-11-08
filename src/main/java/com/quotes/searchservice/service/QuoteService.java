package com.quotes.searchservice.service;

import com.quotes.searchservice.model.Quote;

public interface QuoteService {

	public Quote[] getQuotes(String term);
}
