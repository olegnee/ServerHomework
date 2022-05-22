package com.company;

import java.io.*;
import java.net.*;

public class ServerClient {
    private static Socket clientServer;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        try {
            try {
                clientServer = new Socket("localhost", 8001);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientServer.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientServer.getOutputStream()));
                System.out.println("Write your message:");
                String text = in.readLine();
                out.write(text + "\n");
                out.flush();
                String serverAnswer = in.readLine();
                System.out.println(serverAnswer);
            } finally {
                System.out.println("Client closed.");
                clientServer.close();
                in.close();
                out.close();
            }
        }
        catch (IOException e) {
                System.err.println(e);
        }
    }
}
