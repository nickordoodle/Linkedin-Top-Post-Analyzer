package com.analyzer.io;

import com.analyzer.data.Post;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedInUserCSVReaderTest {
	private String noEntryCSVPath;
	private String oneEntryCSVPath;
	private String partialEntryCSVPath;

	private LinkedInUserCSVReader readerWithNoEntries;
	private LinkedInUserCSVReader readerWithOneEntry;
	private LinkedInUserCSVReader readerWithPartialEntry;

	private List<Post> noPosts;
	private List<Post> onePost;
	private List<Post> partialPost;

	@Before
	public void setUp() throws IOException {
		noEntryCSVPath = "src/com/data/0-post-by-user.csv";
		oneEntryCSVPath = "src/com/data/1-post-by-user.csv";
		partialEntryCSVPath = "src/com/data/partial-post-by-user.csv";

		readerWithNoEntries = new LinkedInUserCSVReader
				(noEntryCSVPath);
		readerWithOneEntry = new LinkedInUserCSVReader
				(oneEntryCSVPath);
		readerWithPartialEntry = new LinkedInUserCSVReader
				(partialEntryCSVPath);

		noPosts = readerWithNoEntries.load();
		onePost = readerWithOneEntry.load();
		partialPost = readerWithPartialEntry.load();
	}

	@Test
	public void testLoadReadsInStandardCSVDataOfNoPosts() {
		List<Post> noPostList = new ArrayList<>();
		assertEquals(noPostList, noPosts);
	}

	@Test
	public void testLoadReadsInStandardCSVDataOfOnePost() {
		List<Post> onePostList = new ArrayList<>();
		Post onlyPost = new Post();
		onlyPost.setPostId(1);
		onlyPost.setMainTextContent("I got hired today by my reach company! (Not Google) Anyways I will be on the second floor of my office :)");
		onlyPost.setListOfHashTags(Arrays.asList("dart", "mobiledevelopment",
				"minimumviableproduct", "crossplatformdevelopment"));
		onlyPost.setNumOfLikes(3);
		onlyPost.setNumOfComments(1);
		onlyPost.setNumOfViews(421);
		onePostList.add(onlyPost);
		assertEquals(onePostList, onePost);
	}

	@Test
	public void testLoadReadsInStandardCSVDataOfPartialPost() {
		List<Post> partialPostList = new ArrayList<>();
		Post partialPost = new Post();
		partialPost.setPostId(3);
		partialPost.setMainTextContent("");
		partialPost.setListOfHashTags(Arrays.asList("mobileapps", "me"));
		partialPost.setNumOfLikes(40);
		partialPost.setNumOfComments(3);
		partialPost.setNumOfViews(405);
		partialPostList.add(partialPost);
		assertEquals(partialPostList, this.partialPost);
	}

}