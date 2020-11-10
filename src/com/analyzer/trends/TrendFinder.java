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

	/**
	 * Returns the top post list to be used internally.
	 * <p>
	 * This method finds the users top posts.  It does this by
	 * first sorting the raw csv data list according to number of
	 * views, then number of likes and finally by number of comments.
	 * This approach assumes that more views, likes and comments
	 * correlate positively with a more popular post according to LinkedIn.
	 * @param  limit  the maximum number of top posts to retrieve
	 * @return      the list of top user posts
	 * @see         List
	 */
	private List<Post> getTopPosts(int limit) {
		return userPostsDataFromCSVFile.stream()
				.sorted(Comparator.comparing(Post::getNumOfViews).reversed()
						.thenComparing(Post::getNumOfLikes).reversed()
						.thenComparing(Post::getNumOfComments).reversed()) // Sort list by number of views then by number of likes and lastly by number of comments
				.limit(limit) // limit outputs to limits that set by user. e.g. first 5.
				.collect(Collectors.toList());
	}


	//TODO change hashtag sniffer function to implement this function
	public abstract List<Post> findTrend(int limit) throws IOException;

	/**
	 * Returns the top users post list.
	 * @return      the top user posts
	 * @see         List
	 */
	public List<Post> getUserPostsDataFromCSVFile() {
		return userPostsDataFromCSVFile;
	}
}
