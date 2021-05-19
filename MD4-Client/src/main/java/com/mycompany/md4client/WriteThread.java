/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.md4client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author rolands
 */
public class WriteThread extends Thread {

    private PrintWriter writer;
    private Socket socket;
    private Connection client;
    private Scanner scanner = new Scanner(System.in);
 
    public WriteThread(Socket socket, Connection client) {
        this.socket = socket;
        this.client = client;
 
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();
        client.setUserName(userName);
        writer.println(userName);
 
        String text;
 
        do {
            text = scanner.nextLine();
            writer.println(text);
        } while (!text.equals("bye"));
 
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
    
}
