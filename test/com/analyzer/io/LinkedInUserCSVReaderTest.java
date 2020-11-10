package com.analyzer.io;

import com.analyzer.data.Post;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedInUserCSVReaderTest {
	private String noEntryCSVPath;
	private String oneEntryCSVPath;
	private String twentyFiveEntriesCSVPath;

	private LinkedInUserCSVReader readerWithNoEntries;
	private LinkedInUserCSVReader readerWithOneEntry;
	private LinkedInUserCSVReader readerWithTwentyFiveEntries;

	private List<Post> noPosts;
	private List<Post> onePost;
	private List<Post> twentyFivePosts;

	@Before
	public void setUp() throws IOException {
		noEntryCSVPath = "src/com/data/0-post-by-user.csv";
		oneEntryCSVPath = "src/com/data/1-post-by-user.csv";
		twentyFiveEntriesCSVPath = "src/com/data/25-post-by-user.csv";

		readerWithNoEntries = new LinkedInUserCSVReader
				(noEntryCSVPath);
		readerWithOneEntry = new LinkedInUserCSVReader
				(oneEntryCSVPath);
		readerWithTwentyFiveEntries = new LinkedInUserCSVReader
				(twentyFiveEntriesCSVPath);

		noPosts = readerWithNoEntries.load();
		onePost = readerWithOneEntry.load();
		twentyFivePosts = readerWithTwentyFiveEntries.load();
	}

	@Test
	public void testLoadReadsInStandardCSVDataOfNoPosts() {
		List<Post> noPostList = new ArrayList<>();
		assertEquals(noPostList, noPosts);
	}

	@Test
	public void testLoadReadsInStandardCSVDataOfOnePost() {
	}

	@Test
	public void testLoadReadsInStandardCSVDataOfTwentyFivePosts() {
	}

}