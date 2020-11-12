package com.analyzer.io;

import com.analyzer.trends.HashtagSniffer;
import com.analyzer.trends.TextContentKeyWordSniffer;
import com.apps.util.Prompter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class IOHandler {
    // Field
    private static String popResult;
    private static Prompter prompter = new Prompter(new Scanner(System.in));
    private static LinkedInUserCSVReader reader;
    private static HashtagSniffer hashtagSniffer;
    private static TextContentKeyWordSniffer keyWordSniffer;
    private static boolean isExit = false;
    private static String csvFilePatch;
    private static String followUpMsg = "Please enter 'Y' to continue to analyze another document or 'N' to exit" + "\n" + ">>";
    private static String welcomeMsg = "Please provide the document in csv format" + "\n" + ">>";
    private static final String goodbyeMsg = "Thank you for choosing Lambda Stream Technology";

    // Constructor
    public IOHandler() {}

    // Methods
    /**
     * Main method in Writer Class, act as a wrapper inside IOHandler.
     * <p>
     * This implementation utilize private methods read(), result(),
     * isExit(), hashtagTrend(), keywordTrend() and regexCleaner
     * to accomplish all IO tasks.
     * for details of each method, consult each individual method
     * API documents.
     *
     */
    public void write() throws IOException, InterruptedException {
        do {
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
     *
     */
    private void read() throws IOException {
        csvFilePatch = prompter.prompt(welcomeMsg);
        reader = new LinkedInUserCSVReader(csvFilePatch);
        reader.load();
    }

    /**
     * output analysis result.
     * <p>
     * This implementation utilize hashtagTrend(), keywordTrend() methods
     * to prepare readable result of analysis.
     * for details of each method, consult each individual method
     * API documents.
     *
     */
    private void result() throws IOException {
        System.out.println("The popular Hashtag(s) is/are: " + regexCleaner(hashtagTrend(5)) + "\n"
                + "The popular Keyword(s) is/are: " + regexCleaner(keywordTrend(5)));
    }

    /**
     * provide flag for program to indicate program flow.
     * <p>
     * This implementation return boolean value to continue or exit
     * the program.
     * for details of each method, consult each individual method
     * API documents.
     *
     */
    private boolean isExit() throws InterruptedException {
        String entry = prompter.prompt(followUpMsg);
        if (entry.toUpperCase().equals("Y")) {
            isExit = true;
        } else {
            System.out.println(goodbyeMsg);
            TimeUnit.SECONDS.sleep(3);
            System.exit(1);
        }
        return isExit;
    }

    /**
     * return list of popular hashtags.
     * <p>
     * This implementation invoke method in HashtagSniffer.
     * for details of each method, consult each individual method
     * API documents.
     *
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
     *
     */
    public List<String> keywordTrend(int numOfResultsToFind) throws IOException {
        keyWordSniffer = new TextContentKeyWordSniffer();
        return keyWordSniffer.findTrend(numOfResultsToFind);
    }
    /**
     * remove open and close bracket from returned string.
     * <p>
     * This implementation invoke replaceAll method with regex.
     * for details of each method, consult each individual method
     * API documents.
     *
     */
    private String regexCleaner(List<String> popResult) {
        return popResult.toString().replaceAll("\\[", "").replaceAll("\\]", "");
    }



}