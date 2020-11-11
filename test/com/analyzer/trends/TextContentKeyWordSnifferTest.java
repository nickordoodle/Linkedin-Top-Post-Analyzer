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
		List<String> keywordResults = textSniffer.findTrend(3);
		System.out.println(Arrays.toString(keywordResults.toArray()));
	}
}