package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TrendFinder {
	// Relative path for the csv data that we work with to be accessed anywhere
	public static final String csvDataFilePath = "./src/com/data/25-posts-by-user-nick.csv";
	// The limit we will use to find the user's most popular posts
	public static final int numOfTopPostsToFind = 5;

	// Custom reader utility class to load csv into a list
	private LinkedInUserCSVReader csvReader;

	// Entire raw list of posts generated from csvFile
	private List<Post> userPostsDataFromCSVFile;

	// Entire raw list of posts generated from csvFile
	private List<Post> userTopPostsFilteredByALimit;

	public TrendFinder() throws IOException {
		csvReader = new LinkedInUserCSVReader(csvDataFilePath);
		userPostsDataFromCSVFile = csvReader.load();
		// Retrieve top posts according to limit so subclasses can use
		userTopPostsFilteredByALimit = getTopPosts(numOfTopPostsToFind);
	}

	/*
	* Read in raw csv data
	* Get top posts in this class and hand them to each sniffer
	* Sniffers give back some something to work with, list or hashmap of something
	 */

	private List<Post> getTopPosts(int limit) {
		List<Post> topPostsList = userPostsDataFromCSVFile.stream()
				.sorted(Comparator.comparing(Post::getNumOfViews).reversed()
						.thenComparing(Post::getNumOfLikes).reversed()
						.thenComparing(Post::getNumOfComments).reversed()) // Sort list by number of views then by number of likes and lastly by number of comments
				.limit(limit) // limit outputs to limits that set by user. e.g. first 5.
				.collect(Collectors.toList());

		//result.addAll(list);
		return topPostsList;
	}


	//TODO change hashtag sniffer function to implement this function
	public abstract List<Post> findTrend(int limit) throws IOException;

	public List<Post> getUserPostsDataFromCSVFile() {
		return userPostsDataFromCSVFile;
	}
}
