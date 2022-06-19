package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8001);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner scanner = new Scanner(System.in)) {
            String msg;
            System.out.println("Enter message for server...");
            msg = scanner.nextLine();
            out.println(msg);
            System.out.println("SERVER: " + in.readLine());
        }

    }
}