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

			int postID = Integer.parseInt(tokens[0].trim());
			String textBody = tokens[1].trim();
			String likes = tokens[3].trim();
			String comments = tokens[4].trim();
			String views = tokens[5].trim();

			result.add(new Post(postID,
					Integer.parseInt(views),
					Integer.parseInt(likes),
					textBody));
		});
		return result;
	}
}