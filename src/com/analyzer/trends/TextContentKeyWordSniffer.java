package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextContentKeyWordSniffer extends TrendFinder {

	private List<Post> textContentOfUserPosts;

	public TextContentKeyWordSniffer() throws IOException {
		this.textContentOfUserPosts = filterTextPosts(getUserTopPostsFilteredByALimit());
	}

	/**
	 * Returns a list of most useful text keywords based on users past top posts.
	 * <p>
	 * Anaylzes the top posts by cross referencing the most common words used.
	 * These will be referred to as 'keywords' and the assumption is that these
	 * keywords positively increased their posts reach according to LinkedIns algorithm.
	 * @param  numOfResultsToFind  the maximum number of results to find
	 * @return      the list of String results
	 * @see         List
	 */
	@Override
	public List<String> findTrend(int numOfResultsToFind) {
		// Find most used verbs and nouns
		List<String> keywordResults = new ArrayList<>();

		// Whats a keyword?  Most common words used throughout posts
		// only compare keywords to other posts, not against its own post
		// Get occurrences of every word in a unique post
		// ie. "development" occurs in Post 1, Post 3, Post 10.
		// so Map<String, occurences> is "development", 3
		// Continue to search and add for keywords until threshold of result is reached

		// Sort result of most used keywords

		// Return sub list of result according to limit
		return keywordResults;
	}

	private List<Post> filterTextPosts(List<Post> userPosts){
		return null;
	}
}
