package com.analyzer.client;

import com.analyzer.io.IOHandler;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        IOHandler ioHandler = new IOHandler();
        ioHandler.write();
    }
}