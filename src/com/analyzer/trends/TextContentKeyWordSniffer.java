package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.helper.Helper;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TextContentKeyWordSniffer extends TrendFinder {
	private List<Post> topUsersPosts;

	public TextContentKeyWordSniffer() throws IOException {
		this.topUsersPosts = getUserTopPostsFilteredByALimit();
	}

	/**
	 * Returns a list of most useful text keywords based on users past top posts.
	 * <p>
	 * Anaylzes the top posts by cross referencing the most common words used.
	 * These will be referred to as 'keywords' and the assumption is that these
	 * keywords will positively increase a post's reach according to LinkedIns algorithm.
	 *
	 * @param numOfResultsToFind the maximum number of results to find
	 * @return the list of String results e.g. {"engineers", "technology", "learn"}
	 * @see List
	 */
	@Override
	public List<String> findTrend(int numOfResultsToFind) {
		// Map all text content into its own list for comparing
		List<String> topPostTextContentList = this.topUsersPosts.stream()
				.map(Post::getMainTextContent)
				.collect(Collectors.toList());

		List<String> listOfKeyWords = new ArrayList<>();
		listOfKeyWords = filterTextPosts(topPostTextContentList);

		Map<String, Integer> keywordOccurrences = incrementKeyWord(listOfKeyWords);

		listOfKeyWords.sort(Comparator.comparingInt(keywordOccurrences::get));

		//TODO Write code to handle return keyword list less than requested numberofresults
		// Return sub list of result according to limit
		return listOfKeyWords.subList(0, numOfResultsToFind - 1);
	}

	/**
	 * Increments a value in a String / Integer Map.
	 * <p>
	 * Iterates over the parameter list and returns a map of
	 * every keywords occurrence.
	 *
	 * @param listOfKeyWords the given list of String keywords
	 * @return the map of occurrences for each keyword from the given list.
	 * @see List
	 */
	private Map<String, Integer> incrementKeyWord(List<String> listOfKeyWords) {
		Map<String, Integer> keywordOccurrences = new HashMap<>();
		listOfKeyWords.forEach(keyword -> {
			if (keywordOccurrences.containsKey(keyword)) {
				// return the current count of this keyword
				Integer newVal = keywordOccurrences.get(keyword) + 1;
				keywordOccurrences.put(keyword, newVal);
			} else {
				// first occurrence of a keyword
				keywordOccurrences.put(keyword, 1);
			}
		});
		return keywordOccurrences;
	}


	/**
	 * Returns a list of Posts with irrelevant words filtered out of their text contents
	 * <p>
	 * Inspects the text content of each post. Removes irrelevant words and grammar
	 * such as: pronouns, prepositions and conjunctions.  Meaningful text content
	 * in this case consists of nouns, verbs, adjectives and adverbs.
	 *
	 * @param userTextContentFromPosts the list of Posts to filter
	 * @return the list of filtered Posts
	 * @see List
	 */
	private List<String> filterTextPosts(List<String> userTextContentFromPosts) {
		List<String> filteredTextContentFromPosts = new ArrayList<>();

		// Filter to only words, remove any empties and remove pronouns, prepositions and conjunctions
		for (String textContent : userTextContentFromPosts) {
			List<String> filteredWords = new ArrayList<>(Arrays.asList(textContent.split("\\W")));
			// Remove any possible empty values included
			filteredWords.removeIf(String::isEmpty);
			filteredWords.removeIf(keyword -> {
				if (Helper.isPronoun(keyword)
						|| Helper.isPreposition(keyword)
						|| Helper.isConjunction(keyword)) {
					return true;
				}
				return false;
			});

			filteredTextContentFromPosts.addAll(filteredWords);
		}

		return filteredTextContentFromPosts;
	}
}
