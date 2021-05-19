/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.md4client;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author rolands
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private Connection client;
 
    public ReadThread(Socket socket, Connection client) {
        this.socket = socket;
        this.client = client;
 
        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
        String response = "";
        while (!response.contains("won")) {
            try {
                response = reader.readLine();
                //System.out.println("Got message: " + response);
                System.out.println(response);
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}
