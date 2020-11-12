package com.analyzer.io;

import com.analyzer.sniffer.HashtagSniffer;
import com.analyzer.sniffer.MainTextContentSniffer;
import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Represents a IOHandler focusing on social media content.
 *
 * @author Jason Zhang
 * @author Nick Scherer
 * @version 1.0
 * @since 1.0
 */
public class IOHandler {
	// Field
	private static String popResult;
	private static Prompter prompter = new Prompter(new Scanner(System.in));
	private static LinkedInUserCSVReader reader;
	private static HashtagSniffer hashtagSniffer;
	private static MainTextContentSniffer keyWordSniffer;
	private static String csvFilePatch;
	private static String followUpMsg = " Take our Advice, Increase your Reach, \n Expand your Network and Watch your Content go Viral! \n"
			+ "Please enter 'Y' to continue to analyze another document or 'N' to exit \n" + "\n" + ">>";
	private static String welcomeMsg = "Please provide the document in csv format" + "\n" + ">>";
	private static final String goodbyeMsg = "Thank you for choosing Lambda Stream Technologies";

	// Constructor
	public IOHandler() {
		super();
	}

	// Methods

	/**
	 * Main method in Writer Class, act as a wrapper inside IOHandler.
	 * <p>
	 * This implementation utilize private methods read(), result(),
	 * isExit(), hashtagTrend(), keywordTrend() and regexCleaner
	 * to accomplish all IO tasks.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	public void initialize() throws IOException, InterruptedException {
		do {
			bannerLoader();
			read();
			result();
		}
		while (isExit());
	}

	/**
	 * process user entry and invoke load() method in LinkedInUserCSVReader.
	 * <p>
	 * This implementation utilize load() method in LinkedInUserCSVReader
	 * to capture data from csv document for further process.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	private void read() throws IOException, InterruptedException {
		csvFilePatch = prompter.prompt(welcomeMsg);
		try {
			if (!csvFilePatch.equals("")) {
				reader = new LinkedInUserCSVReader(csvFilePatch);
				reader.load();
			} else {
				System.out.println("Sorry, Not a Valid path, Please try again.");
				TimeUnit.SECONDS.sleep(1);
				cleanScreen();
				initialize();
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Sorry, Not a Valid path, Please try again." + "\n" +
					"Please provide a valid document " +
					"or you can refer to historical recommendation below");
			TimeUnit.SECONDS.sleep(1);
		}
	}

	/**
	 * output analysis result.
	 * <p>
	 * This implementation utilize hashtagTrend(), keywordTrend() methods
	 * to prepare readable result of analysis.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	private void result() throws IOException {
		System.out.println("\n Based on the historical profile data and performance, \n" +
				" we recommend you use the following types of content in future posts. \n" +
				"\n Use these #hashtags: " + regexCleaner(hashtagTrend(5)) + "\n"
				+ "\n Use these keyword(s): " + regexCleaner(keywordTrend(5)) + "\n");
	}

	/**
	 * provide flag for program to indicate program flow.
	 * <p>
	 * This implementation return boolean value to continue or exit
	 * the program.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	private boolean isExit() throws InterruptedException, IOException {
		String entry = prompter.prompt(followUpMsg);
		if (!entry.toUpperCase().equals("N") && !entry.toUpperCase().equals("Y")) {
			System.out.println("Sorry, Not a Valid path, Please try again.");
			isExit();
		} else if (entry.toUpperCase().equals("N")) {
			System.out.println(goodbyeMsg);
			TimeUnit.SECONDS.sleep(3);
			System.exit(1);
		}
		return true;
	}


	/**
	 * return list of popular hashtags.
	 * <p>
	 * This implementation invoke method in HashtagSniffer.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	public List<String> hashtagTrend(int numOfResultsToFind) throws IOException {
		hashtagSniffer = new HashtagSniffer();
		return hashtagSniffer.findTrend(numOfResultsToFind);
	}

	/**
	 * return list of popular keywords.
	 * <p>
	 * This implementation invoke method in TextContentKeyWordSniffer.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	public List<String> keywordTrend(int numOfResultsToFind) throws IOException {
		keyWordSniffer = new MainTextContentSniffer();
		return keyWordSniffer.findTrend(numOfResultsToFind);
	}

	/**
	 * remove open and close bracket from returned string.
	 * <p>
	 * This implementation invoke replaceAll method with regex.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	private String regexCleaner(List<String> popResult) {
		return popResult.toString().replaceAll("\\[", "").replaceAll("\\]", "");
	}

	/**
	 * load and print banner from banner.txt file.
	 * <p>
	 * This implementation read from external txt file for banner.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	private void bannerLoader() throws IOException {
		try {
			String banner = Files.readString(Path.of("src", "com", "data", "banner.txt"));
			System.out.println(banner);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Clear screen if user decide to continue or click enter without valid path.
	 * <p>
	 * This implementation issue a system command base on system type.
	 * for details of each method, consult each individual method
	 * API documents.
	 */
	public static void cleanScreen() throws IOException {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			Runtime.getRuntime().exec("cls");
		} else {
			Runtime.getRuntime().exec("clear");
		}
	}

}