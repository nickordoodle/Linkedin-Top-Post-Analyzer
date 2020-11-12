package com.analyzer.trends;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TextContentKeyWordSnifferTest {
	private TextContentKeyWordSniffer textSniffer;

	@Before
	public void setUp() throws Exception {
		textSniffer = new TextContentKeyWordSniffer();
	}

	@Test
	public void findTrend() {
		List<String> keywordResults = textSniffer.findTrend(1000);
		System.out.println(keywordResults.size());
		System.out.println(Arrays.toString(keywordResults.toArray()));
	}

	@Test
	public void findTrendBadInput() {
		List<String> keywordResults = textSniffer.findTrend(0);
		System.out.println(keywordResults.size());
		System.out.println(Arrays.toString(keywordResults.toArray()));
	}


}