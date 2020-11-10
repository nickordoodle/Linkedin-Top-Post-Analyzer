package com.analyzer.trends;

import com.analyzer.data.Post;
import com.analyzer.io.LinkedInUserCSVReader;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextContentKeyWordSniffer extends TrendFinder {

	public TextContentKeyWordSniffer() throws IOException {
	}

	@Override
	public List<String> findTrend(int numOfResultsToFind) {
		return null;
	}
}
