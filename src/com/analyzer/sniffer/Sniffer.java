package com.analyzer.sniffer;

import com.analyzer.model.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract Sniffer class with csv inputs used to implement String based searches.
 *
 * @author Nick Scherer
 * @author Jason Zhang
 * @version 1.0
 * @since 1.0
 */
public abstract class Sniffer {

	/**
	 * Sample data csv path.
	 */
	public static final String csvSampleDataFilePath = "./resources/sample-csv-data-file-of-25-posts.csv";

	/**
	 * Default value determining to find the top N posts.
	 * N being this value.
	 */
	public static final int numOfTopPostsToFind = 5;

	// Class Fields

	// Custom reader utility class to load csv into a list
	private LinkedInUserCSVReader csvReader;

	// Entire raw list of posts generated from csvFile
	private List<Post> userPostsDataFromCSVFile;

	// Entire raw list of posts generated from csvFile
	private List<Post> userTopPostsFilteredByALimit;

	/**
	 * Creates a Sniffer. Loads the csv file data and sets the top posts.
	 * @throws IOException
	 */
	public Sniffer() throws IOException {
		// Initialize the reader and load the csv file.
		setCSVReader(new LinkedInUserCSVReader(csvSampleDataFilePath));
		setUserPostsDataFromCSVFile(csvReader.load());
		// Initialize top posts according to limit so subclasses can use
		setUserTopPostsFilteredByALimit(getTopPosts(numOfTopPostsToFind));
	}

	/**
	 * Returns the top post list to be used internally.
	 * <p>
	 * This method finds the users top posts.  It does this by
	 * first sorting the raw csv data list according to number of
	 * views, then number of likes and finally by number of comments.
	 * This approach assumes that more views, likes and comments
	 * correlate positively with a more popular post according to LinkedIn.
	 *
	 * @param limit the maximum number of top posts to retrieve
	 * @return the list of top user posts
	 * @see List
	 */
	private List<Post> getTopPosts(int limit) {
		return userPostsDataFromCSVFile.stream()
				.sorted(Comparator.comparing(Post::getNumOfViews).reversed()
						.thenComparing(Post::getNumOfLikes).reversed()
						.thenComparing(Post::getNumOfComments).reversed()) // Sort list by number of views then by number of likes and lastly by number of comments
				.limit(limit) // limit outputs to limits that set by user. e.g. first 5.
				.collect(Collectors.toList());
	}

	/**
	 * Returns a list of trend results according to users top posts.
	 * <p>
	 * This implementation specific method analyzes the top user posts.
	 * It then will determine useful information for the user to know
	 * and returns a list of Strings as a result for future output.
	 *
	 * @param numOfResultsToFind the maximum number of results to find
	 * @return the list of String results
	 * @see List
	 */
	public abstract List<String> findTrend(int numOfResultsToFind) throws IOException;

	/**
	 * Returns the top users post list.
	 *
	 * @return the top user posts limited to a certain number of values
	 * @see List
	 */
	public List<Post> getUserTopPostsFilteredByALimit() {
		return userTopPostsFilteredByALimit;
	}

	/**
	 * Sets the users top posts.
	 */
	private void setUserTopPostsFilteredByALimit(List<Post> userTopPostsFilteredByALimit) {
		this.userTopPostsFilteredByALimit = userTopPostsFilteredByALimit;
	}

	/**
	 * Sets the CSV Reader.
	 */
	private void setCSVReader(LinkedInUserCSVReader csvReader) {
		this.csvReader = csvReader;
	}

	/**
	 * Sets the user posts data list.
	 */
	private void setUserPostsDataFromCSVFile(List<Post> userPostsDataFromCSVFile) {
		this.userPostsDataFromCSVFile = userPostsDataFromCSVFile;
	}


}
