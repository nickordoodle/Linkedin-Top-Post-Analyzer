package com.analyzer.io;

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

			String postID = tokens[0];
			String textBody = tokens[1];
			String hashTags = tokens[2];
			String likes = tokens[3];
			String comments = tokens[4];
			String views = tokens[5];

			result.add(new Post(Integer.parseInt(postID),
					textBody, hashTags,
					Integer.parseInt(likes),
					Integer.parseInt(comments),
					Integer.parseInt(views)));
		});
		return result;
	}
}