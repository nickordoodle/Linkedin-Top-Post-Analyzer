package com.analyzer.io;

import com.analyzer.data.Post;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LinkedInUserCSVReader {
	private Path dataFilePath;

	public LinkedInUserCSVReader(String dataFilePath) {
		this.dataFilePath = Path.of(dataFilePath);
	}

	public List<Post> load() throws IOException {
		List<Post> result = new ArrayList<>();

		Files.lines(dataFilePath).forEach(line -> {
			// Separate all tokens on each line by a comma
			String[] tokens = line.split(",");

			// Read in csv tokens on each line, clean data of extra hidden characters
			String postIdString = tokens[0].replaceAll("[^0-9]+", "");
			String textBody = tokens[1].trim();
			String hashTags = tokens[2].trim();
			String likesString = tokens[3].replaceAll("[^0-9]+", "");
			String commentsString = tokens[4].replaceAll("[^0-9]+", "");
			String viewsString = tokens[5].replaceAll("[^0-9]+", "");

			// Change raw string input to appropriate type
			int postID = Integer.parseInt(postIdString);
			String[] hashTagsDelimited = hashTags.split("#");
			List<String> hashTagList = Arrays.asList(hashTagsDelimited);
			int likes = Integer.parseInt(likesString);
			int comments = Integer.parseInt(commentsString);
			int views = Integer.parseInt(viewsString);

			// Create a new object with the converted values
			result.add(new Post(postID, textBody, hashTagList,
					likes, comments, views));
		});
		return result;
	}
}