package com.analyzer.io;

import junit.framework.TestCase;
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
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}