package com.analyzer.trends;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HashtagSnifferTest extends TestCase {
    public HashtagSniffer hSniffer;

    @Before
    public void setUp() throws IOException {
        hSniffer = new HashtagSniffer();
    }

    @Test
    public void testHashtagSniffer_resultShouldMatch() throws IOException {
        // expected result should match "[softwaredevelopment]"
        assertEquals("[softwaredevelopment]", hSniffer.findTrend(5).toString());
    }
}
