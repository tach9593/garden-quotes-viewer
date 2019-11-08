package com.quotes.searchservice;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.quotes.searchservice.model.Quote;
import com.quotes.searchservice.model.QuoteResults;
import com.quotes.searchservice.service.QuoteServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuoteSearchServiceApplicationTests {

	@Autowired
	public QuoteServiceImpl quoteService;
	
	@Test
	public void testRemovalOfDuplicates() {
		QuoteResults results = new QuoteResults();
		results.setCount(5);
		List<Quote> quotes = new ArrayList<Quote>();
		quotes.add(addQ("Don't cry because it's over. Smile because it happened.", "Dr. Seuss"));
		quotes.add(addQ("Don't cry because it's over. Smile because it happened.", "Dr. Seuss"));
		quotes.add(addQ("Don't be afraid to go out on a limb. That's where the fruit is.", "H. Jackson Browne"));
		quotes.add(addQ("Don't be afraid to go out on a limb. That's where the fruit is.", "H. Jackson Browne"));
		quotes.add(addQ("Don't be afraid to go out on a limb. That's where the fruit is.", "H. Jackson Browne"));
		quotes.add(addQ("You got to be careful if you don't know where you're going, because you might not get there.", "aRobert Stevenson"));
		quotes.add(addQ("Don't judge each day by the harvest you reap but by the seeds that you plant.", "Robert Stevenson"));
		quotes.add(addQ("Don't judge each day by the harvest you reap but by the seeds you plant.", "Robert Stevenson"));
		results.setResults(quotes);  
		List<Quote> quotesToTest = quoteService.resultBuilder(results);
		
		assertTrue(quotesToTest.get(0).getQuoteText().equals("Don't be afraid to go out on a limb. That's where the fruit is."));
		assertTrue(quotesToTest.get(1).getQuoteText().equals("Don't cry because it's over. Smile because it happened."));
		assertTrue(quotesToTest.get(2).getQuoteText().equals("Don't judge each day by the harvest you reap but by the seeds that you plant."));
		assertTrue(quotesToTest.get(3).getQuoteText().equals("Don't judge each day by the harvest you reap but by the seeds you plant."));
	}

	@Test
	public void testAlphabeticSortOfResults() {
		QuoteResults results = new QuoteResults();
		results.setCount(5);
		List<Quote> quotes = new ArrayList<Quote>();
		quotes.add(addQ("Don't cry because it's over. Smile because it happened.", "Dr. Seuss"));
		quotes.add(addQ("Don't cry because it's over. Smile because it happened.", "Dr. Seuss"));
		quotes.add(addQ("Don't be afraid to go out on a limb. That's where the fruit is.", "H. Jackson Browne"));
		quotes.add(addQ("Don't be afraid to go out on a limb. That's where the fruit is.", "H. Jackson Browne"));
		quotes.add(addQ("Don't be afraid to go out on a limb. That's where the fruit is.", "H. Jackson Browne"));
		quotes.add(addQ("You got to be careful if you don't know where you're going, because you might not get there.", "aRobert Stevenson"));
		quotes.add(addQ("Don't judge each day by the harvest you reap but by the seeds you plant.", "Yogi Berra"));
		results.setResults(quotes);  
		List<Quote> quotesToTest = quoteService.resultBuilder(results);
		
		assertTrue(quotesToTest.get(0).getQuoteText().equals("Don't be afraid to go out on a limb. That's where the fruit is."));
		assertTrue(quotesToTest.get(1).getQuoteText().equals("Don't cry because it's over. Smile because it happened."));
		assertTrue(quotesToTest.get(2).getQuoteText().equals("Don't judge each day by the harvest you reap but by the seeds you plant."));
		assertTrue(quotesToTest.get(3).getQuoteText().equals("You got to be careful if you don't know where you're going, because you might not get there."));
	}

	public Quote addQ(String text, String author) {
		Quote q1 = new Quote();
		q1.setQuoteText(text);
		q1.setQuoteAuthor(author);
		return q1;
	}
}
