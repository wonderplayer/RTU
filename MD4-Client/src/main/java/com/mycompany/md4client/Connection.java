package com.mycompany.md4client;
import java.net.*;
import java.io.*;

public class Connection {
    private String hostname;
    private int port;
    private String userName;
    private boolean canWrite = true;
 
    public Connection(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }
 
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
 
            System.out.println("Connected to the chat server");
            System.out.println("When you are ready, type 'Y' in order to start the game");
            new ReadThread(socket, this).start();
            new WriteThread(socket, this).start();
 
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
 
    }
 
    void setUserName(String userName) {
        this.userName = userName;
    }
 
    String getUserName() {
        return this.userName;
    }
    
    public boolean GetCanWrite(){
        return canWrite;
    }
    
    public void SetCanWrite(boolean value){
        canWrite = value;
    }
}
