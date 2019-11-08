package com.quotes.searchservice.model;

import java.util.List;

public class QuoteResults {

	 private Integer count;

	 private List<Quote> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Quote> getResults() {
		return results;
	}

	public void setResults(List<Quote> results) {
		this.results = results;
	}
}
