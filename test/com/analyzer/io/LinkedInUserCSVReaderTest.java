package com.analyzer.io;

import com.analyzer.data.Post;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

public class LinkedInUserCSVReaderTest extends TestCase {
	public void testLoadReadsInStandardCSVDataOf25Posts() {
		LinkedInUserCSVReader reader = new LinkedInUserCSVReader
				("C:\\StudentWork\\MiniProject\\" +
						"Linkedin-Top-Post-Analyzer\\src\\" +
						"com\\data\\nick-sample-data-25-entries-no-commas.csv");
		try {
			List<Post> result = reader.load();
			result.toString();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}