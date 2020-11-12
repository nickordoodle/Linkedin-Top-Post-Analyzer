package com.analyzer.client;

import com.analyzer.io.IOHandler;

import java.io.IOException;

/**
 * Represents the program entry point to LinkedIn Top Post Analyzer.
 *
 * @author Jason Zhang
 * @author Nick Scherer
 * @version 1.0
 * @since 1.0
 */
public class Client {

	public static void main(String[] args) throws IOException, InterruptedException {
		IOHandler ioHandler = new IOHandler();
		ioHandler.write();
	}
}
