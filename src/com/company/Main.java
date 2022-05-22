package com.company;

import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8001);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("New connection accepted");
        final String name = in.readLine();
        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
    }
}
