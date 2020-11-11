package com.analyzer.client;
/*
 *
 */

import com.analyzer.io.LinkedInUserCSVReader;
import com.analyzer.trends.HashtagSniffer;
import com.apps.util.Prompter;

import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;

public class Client {
	public static String csvFilePatch;
	private static String popHashtag;

	public static void main(String[] args) throws IOException {
		// this Prompter HAS-A Scanner, and that Scanner reads input from the console (System.in)
		Prompter prompter = new Prompter(new Scanner(System.in));
		csvFilePatch = prompter.prompt("Please provide the document in csv format ");
		LinkedInUserCSVReader reader = new LinkedInUserCSVReader(csvFilePatch);
		reader.load();
		HashtagSniffer hashtagSniffer = new HashtagSniffer();
		popHashtag =  hashtagSniffer.findTrend(5).toString();
		System.out.println("The most popular hashtag is/ are: " + popHashtag);
	}
}