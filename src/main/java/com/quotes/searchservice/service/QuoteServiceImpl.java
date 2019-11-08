package com.quotes.searchservice.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.quotes.searchservice.config.QuotesUrl;
import com.quotes.searchservice.exceptions.APIServiceException;
import com.quotes.searchservice.model.Quote;
import com.quotes.searchservice.model.QuoteResults;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	public QuotesUrl quotesUrl;

	@Autowired
	public RestTemplate restTemplate;

	@Override
	public Quote[] getQuotes(String term) {
		QuoteResults results = callPublicAPI(term);
		List<Quote> list = resultBuilder(results);
		return list.toArray(new Quote[list.size()]);
	}

	public QuoteResults callPublicAPI(String term) {

		try {
			return (QuoteResults) restTemplate.getForObject(quotesUrl.getUrl() + term, QuoteResults.class);
		} catch (RestClientException e) {
			throw new APIServiceException("Sorry something happened calling the Public API service");
		}
	}

	public List<Quote> resultBuilder(QuoteResults quotes) {

		Map<String, Object> mapOfDistinctQuotes = quotes
				.getResults().stream().<Map<String, Quote>>collect(HashMap::new,
						(map, Quote) -> map.put(Quote.getQuoteText(), Quote), Map::putAll)
				.values().stream().collect(Collectors.toMap(Quote::getQuoteText, Quote -> Quote));

		LinkedHashMap<String, Quote> sortedMapByQuoteText = new LinkedHashMap<>();
		mapOfDistinctQuotes.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEachOrdered(x -> sortedMapByQuoteText.put(x.getKey(), (Quote) x.getValue()));

		return sortedMapByQuoteText.values().stream().collect(Collectors.toList());
	}
}
