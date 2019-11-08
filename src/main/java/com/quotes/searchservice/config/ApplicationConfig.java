package com.quotes.searchservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public QuotesUrl quotesUrl() {
		QuotesUrl quotesUrl = new QuotesUrl();
		quotesUrl.setUrl(env.getProperty("gardenQuotes.url"));
		return quotesUrl;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
