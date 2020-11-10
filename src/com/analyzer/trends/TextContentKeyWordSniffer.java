package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.*;
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
// sorting list, return a list of List<String> of hashtags for the top ${numOfResultsToFind} post/s.

		// Map all text content into its own list for comparing
		List<String> topPostTextContentList = getUserTopPostsFilteredByALimit().stream()
				.map(Post::getMainTextContent)
				.collect(Collectors.toList());

		// flatten list into an list of string of all hashtags retrived.
//		List<String> listOfKeyWords = topPostTextContentList.stream()
//				.flatMap(Collection::stream)
//				.collect(Collectors.toList());

		// Insert listOfHashtags into Map<Integer, String>
//		Map<Integer, String> mod = new HashMap<>();
//		for (int i = 0; i < listOfKeyWords.size(); i++) {
//			int count = 0;
//			for (int j = 0; j < listOfKeyWords.size(); j++) {
//				if (listOfKeyWords.get(i).equals(listOfKeyWords.get(j))) {
//					++count;
//				}
//			}
//			// insert number of appearance as key, and the Hashtag itself as its value] into HashMap mod.
//			mod.put(count, listOfKeyWords.get(i));
//		}
//
//
//		// Find out the maximum appearances numbers.
//		for (int count : mod.keySet()) {
//			if (count > max) {
//				max = count;
//			}
//		}
//
//		int finalMax = max;
//        /*   // a sneak peak of the result of Map mode.
//            for (Map.Entry<Integer,String> key: mod.entrySet()){
//            System.out.println(key.getValue() +" appeared "+ key.getKey() +" time/s");
//        }*/
//		List<String> keywordResults = mod.entrySet().stream()
//				.filter(c -> c.getKey() == finalMax)
//				.map(Map.Entry::getValue)
//				.collect(Collectors.toList());

		// Return sub list of result according to limit
		return keywordResults;
	}


	//TODO implement, should remove prepositions, pronouncs, conjunctions etc.
	private List<Post> filterTextPosts(List<Post> userPosts){
		return null;
	}
}
