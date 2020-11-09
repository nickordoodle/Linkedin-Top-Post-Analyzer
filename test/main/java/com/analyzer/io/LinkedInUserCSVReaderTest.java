package main.java.com.analyzer.io;

import junit.framework.TestCase;

import java.util.List;

public class LinkedInUserCSVReaderTest extends TestCase {

	public void testLoad() {
		LinkedInUserCSVReader reader = new LinkedInUserCSVReader
				("C:\\StudentWork\\MiniProject\\Linkedin-Top-Post-Analyzer\\src\\main\\java\\com\\data");
		try {
			List<Post> result = reader.load();
			result.toString();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}