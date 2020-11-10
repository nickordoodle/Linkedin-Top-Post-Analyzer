package com.analyzer.trends;

import com.analyzer.data.Post;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TextContentKeyWordSniffer extends TrendFinder {
	private List<Post> topUsersPosts;

	public TextContentKeyWordSniffer() throws IOException {
		this.topUsersPosts = filterTextPosts(getUserTopPostsFilteredByALimit());
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

		// Whats a keyword?  Most common words used throughout posts
		// only compare keywords to other posts, not against its own post
		// Get occurrences of every word in a unique post
		// ie. "development" occurs in Post 1, Post 3, Post 10.
		// so Map<String, occurences> is "development", 3
		// Continue to search and add for keywords until threshold of result is reached
// sorting list, return a list of List<String> of hashtags for the top ${numOfResultsToFind} post/s.

		// Map all text content into its own list for comparing
		List<String> topPostTextContentList = this.topUsersPosts.stream()
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

		//TODO Write code to handle return keyword list less than requested numberofresults
		// Return sub list of result according to limit
		return listOfKeyWords.subList(0, numOfResultsToFind - 1);
	}


	/**
	 * Returns a list of Posts with irrelvant words filtered out of their text contents
	 * <p>
	 * Inspects the text content of each post. Removes irrelevant words and grammar
	 * such as: pronouns, prepositions and conjunctions.  Meaningful text content
	 * in this case consists of nouns, verbs, adjectives and adverbs.
	 *
	 * @param userPosts the list of Posts to filter
	 * @return the list of filtered Posts
	 * @see List
	 */
	private List<Post> filterTextPosts(List<Post> userPosts) {
		//TODO implement, should remove prepositions, pronouncs, conjunctions etc.
		return null;
	}
}
