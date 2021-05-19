package com.mycompany.md4client;

public class Client {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 9876;
 
        Connection client = new Connection(hostname, port);
        client.execute();
    }
}
