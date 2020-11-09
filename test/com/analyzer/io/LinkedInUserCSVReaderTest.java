package com.analyzer.io;

import com.analyzer.data.Post;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class LinkedInUserCSVReaderTest {

	@Test
	public void testLoadReadsInStandardCSVDataOf25Posts() {
		LinkedInUserCSVReader reader = new LinkedInUserCSVReader
				("src/com/data/nick-sample-data-25-entries-no-commas.csv");
		try {
			List<Post> result = reader.load();
			for (Post post: result    ) {
				System.out.println(post);

			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}