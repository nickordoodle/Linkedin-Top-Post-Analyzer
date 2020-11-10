package com.analyzer.trends;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class HashtagSnifferTest extends TestCase {

    @Test
    public void testHashtagSniffer() throws IOException {
        HashtagSniffer hSniffer = new HashtagSniffer
                ("./src/com/data/25-posts-by-user-nick.csv");
        // the 1st post should have a id of 15.
        Assert.assertEquals(15, hSniffer.hashtagSniffer().get(0).getPostId());
        // the size of the returned list should match limits
        //Assert.assertEquals(5, hSniffer.hashtagSniffer().size());
        System.out.println(hSniffer.hashtagSniffer().size());
    }
}