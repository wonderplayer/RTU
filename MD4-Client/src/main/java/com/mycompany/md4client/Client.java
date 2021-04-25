package com.mycompany.md4client;

public class Client {

    public static void main(String[] args) {
        Connection client = new Connection();
        client.startConnection("127.0.0.1", 9876);
        String response = client.sendMessage("hello server");
        System.out.println(response);
    }
}
