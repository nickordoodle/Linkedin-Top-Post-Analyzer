package com.analyzer.io;

import com.analyzer.data.Post;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class LinkedInUserCSVReader {
	private Path dataFilePath;

	public LinkedInUserCSVReader(String dataFilePath) {
		this.dataFilePath = Path.of(dataFilePath);
	}

	public List<Post> load() throws IOException {
		List<Post> result = new ArrayList<>();

		Files.lines(dataFilePath).forEach(line -> {
			String[] tokens = line.split(",");

			String postIdString = tokens[0].replaceAll("[^0-9]+", "");
			int postID = Integer.parseInt(postIdString);
			String textBody = tokens[1].trim();
			String hashtags = tokens[2].trim();
			String likesString = tokens[3].replaceAll("[^0-9]+", "");
			int likes = Integer.parseInt(likesString);
			String commentsString = tokens[4].replaceAll("[^0-9]+", "");
			int comments = Integer.parseInt(commentsString);
			String viewsString = tokens[5].replaceAll("[^0-9]+", "");
			int views = Integer.parseInt(viewsString);


			result.add(new Post(postID, textBody, hashtags,
					likes, comments, views));
		});
		return result;
	}
}