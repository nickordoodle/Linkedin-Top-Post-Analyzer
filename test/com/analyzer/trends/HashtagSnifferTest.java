package com.analyzer.trends;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


import static org.junit.Assert.assertEquals;

public class HashtagSnifferTest {
	private HashtagSniffer hSniffer;

	@Before
	public void setUp() throws IOException {
		hSniffer = new HashtagSniffer();
	}

	@Test
	public void testHashtagSniffer() throws IOException {

		// expected result should match "[softwaredevelopment]"
		assertEquals("[softwaredevelopment]", hSniffer.findTrend(5).toString());

		//System.out.println();
		//System.out.println(hSniffer.findTrend(5));
	}
}

