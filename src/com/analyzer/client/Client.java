package com.analyzer.client;
/*
 *
 */

import com.analyzer.io.LinkedInUserCSVReader;
import com.analyzer.trends.HashtagSniffer;
import com.analyzer.trends.TextContentKeyWordSniffer;
import com.apps.util.Prompter;

import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;

public class Client {

    private static String popHashtag;
    private static String popKeyword;
    public static String csvFilePatch;
    private static String isExit;
    private static LinkedInUserCSVReader reader;
    private static HashtagSniffer hashtagSniffer;
    private static TextContentKeyWordSniffer keyWordSniffer;

    public static void main(String[] args) throws IOException {
        // TODO: try/catch promoter for FileNotExistException
        do {
            // this Prompter HAS-A Scanner, and that Scanner reads input from the console (System.in)
            Prompter prompter = new Prompter(new Scanner(System.in));
            csvFilePatch = prompter.prompt("Please provide the document in csv format" + "\n" + ">>");
            reader = new LinkedInUserCSVReader(csvFilePatch);
            reader.load();
            hashtagSniffer = new HashtagSniffer();
            keyWordSniffer = new TextContentKeyWordSniffer();
            popHashtag = hashtagSniffer.findTrend(5).toString().replaceAll("\\[","").replaceAll("\\]","");
            popKeyword = keyWordSniffer.findTrend(5).toString().replaceAll("\\[","").replaceAll("\\]","");
            System.out.println("The popular Hashtag(s) is/are: " + popHashtag + "\n"
                    + "The popular Keyword(s) is/are: " + popKeyword);
            System.out.println();
            isExit = prompter.prompt("Would you like to analyze another document or exit program" + "\n"
                    + "Please enter 'Y' to continue or 'N' to exit" + "\n" + ">>");
        }
        while (isExit.toLowerCase().equals("y"));
    }
}