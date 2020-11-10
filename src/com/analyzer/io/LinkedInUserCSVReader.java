package com.analyzer.io;

import com.analyzer.data.Post;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class LinkedInUserCSVReader {
	private Path dataFilePath;

	public LinkedInUserCSVReader(String dataFilePath) {
		this.dataFilePath = Path.of(dataFilePath);
	}

	public List<Post> load() throws IOException, ArrayIndexOutOfBoundsException {
		Stream<String> readData = Files.lines(dataFilePath);
		if(readData.findFirst().isEmpty())
			return Collections.emptyList();

		List<Post> result = new ArrayList<>();

		Files.lines(dataFilePath).forEach(line -> {

			// Separate all tokens on each line by a comma
			String[] tokens = line.split(",");

			// Partial entry found
			if(tokens.length != Post.class.getDeclaredFields().length){
				// Handle accordingly

			} else {
				// Read in csv tokens on each line, clean data of extra hidden characters
				String postIdString = tokens[0].replaceAll("[^0-9]+", "");
				String textBody = tokens[1].trim();

				String hashTags = tokens[2].trim();
				hashTags = hashTags.replaceAll("\\s", "");

				String likesString = tokens[3].replaceAll("[^0-9]+", "");
				String commentsString = tokens[4].replaceAll("[^0-9]+", "");
				String viewsString = tokens[5].replaceAll("[^0-9]+", "");

				// Change raw string input to appropriate type
				int postID = Integer.parseInt(postIdString);
				// Further data cleaning for splitting up hashtags
				String[] hashTagsDelimited = hashTags.split("#");
				String[] hashTagsDelimitedNonNullValues = Arrays.stream(hashTagsDelimited)
						.filter(s -> (s != null && s.length() > 0))
						.toArray(String[]::new);
				ArrayList<String> hashTagArrayList = new ArrayList<>();
				hashTagArrayList.addAll(Arrays.asList(hashTagsDelimitedNonNullValues));


				int likes = Integer.parseInt(likesString);
				int comments = Integer.parseInt(commentsString);
				int views = Integer.parseInt(viewsString);

				// Create a new object with the converted values
				result.add(new Post(postID, textBody, hashTagArrayList,
						likes, comments, views));
			}

		});
		return result;
	}
}