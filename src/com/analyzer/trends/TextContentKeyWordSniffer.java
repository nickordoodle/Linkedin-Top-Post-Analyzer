package com.analyzer.trends;

import com.analyzer.data.Post;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TextContentKeyWordSniffer extends TrendFinder {
	private int maxKeyWordAppearances = 0; // max number of hashtags appearances

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
	 *
	 * @param numOfResultsToFind the maximum number of results to find
	 * @return the list of String results
	 * @see List
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
// sorting list, return a list of List<String> of hashtags for the top ${numOfResultsToFind} post/s.

		// Map all text content into its own list for comparing
		List<String> topPostTextContentList = getUserTopPostsFilteredByALimit().stream()
				.map(Post::getMainTextContent)
				.collect(Collectors.toList());

		List<String> listOfKeyWords = new ArrayList<>();

		for (String textContent: topPostTextContentList){
			List<String> filteredWords = Arrays.asList(textContent.split("\\W"));
			// Remove any possible empty values included
			filteredWords.removeIf(String::isEmpty);
			listOfKeyWords.addAll(filteredWords);
		}

		Map<String, Integer> keywordOccurrences = new HashMap<>();
		listOfKeyWords.forEach(keyword -> {
			if(keywordOccurrences.containsKey(keyword)){
				// return the current count of this keyword
				Integer newVal = keywordOccurrences.get(keyword) + 1;
				keywordOccurrences.put(keyword, newVal);
			} else {
				// first occurrence of a keyword
				keywordOccurrences.put(keyword, 1);
			}
		});

		listOfKeyWords.sort(Comparator.comparingInt(keywordOccurrences::get));

		// Return sub list of result according to limit
		return listOfKeyWords.subList(0, numOfResultsToFind - 1);
	}


	//TODO implement, should remove prepositions, pronouncs, conjunctions etc.
	private List<Post> filterTextPosts(List<Post> userPosts) {
		return null;
	}
}
