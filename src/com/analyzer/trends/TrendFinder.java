package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.List;

public abstract class TrendFinder {
	// Relative path for the csv data that we work with to be accessed anywhere
	public static final String csvDataFilePath = "./src/com/data/25-posts-by-user-nick.csv";

	// Custom reader utility class to load csv into a list
	private LinkedInUserCSVReader csvReader;

	// Entire raw list of posts generated from csvFile
	private List<Post> userPostsDataFromCSVFile;

	public TrendFinder() throws IOException {
		csvReader = new LinkedInUserCSVReader(csvDataFilePath);
		userPostsDataFromCSVFile = csvReader.load();
	}

	/*
	* Read in raw csv data
	* Get top posts in this class and hand them to each sniffer
	* Sniffers give back some something to work with, list or hashmap of something
	 */

	//TODO change hashtag sniffer function to implement this function
	public abstract List<Post> findTrend(int limit) throws IOException;

	public List<Post> getUserPostsDataFromCSVFile() {
		return userPostsDataFromCSVFile;
	}
}
