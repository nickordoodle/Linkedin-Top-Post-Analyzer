package com.analyzer.trends;

import com.analyzer.data.Post;
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
        Assert.assertEquals(15, hSniffer.hashtagSniffer(5).get(0).getPostId());
        // the size of the returned list should match limits
        Assert.assertEquals(5, hSniffer.hashtagSniffer(5).size());
        // print out hashtags of the top 5 post
        hSniffer.hashtagSniffer(5).forEach(x-> System.out.println(x.getListOfHashTags()));
    }
}