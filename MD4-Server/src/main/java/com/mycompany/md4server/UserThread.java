/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.md4server;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author rolands
 */
public class UserThread implements IUserThread {

    private Socket socket;
    private Connection server;
    private PrintWriter writer;
    private IPlayer player;
    private boolean guessing = true;
    private boolean ready = false;

    public UserThread(Socket socket, Connection server, IPlayer player) {
        this.socket = socket;
        this.server = server;
        this.player = player;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            printUsers();

            String userName = reader.readLine();
            player.SetName(userName);

            String serverMessage = "New user connected: " + userName;
            server.broadcast(serverMessage);
            
            String message = reader.readLine();
            while(!message.equals("Y")){
                this.sendMessage("Please, input 'Y' to proceed");
                message = reader.readLine();
            };
            this.ready = true;
            
            boolean allPlayersReady = server.CheckReady();
            if(!allPlayersReady){
                this.sendMessage("Waiting for other players...");
            }
            while(!allPlayersReady){
                allPlayersReady = server.CheckReady();
            }
            
            String clientMessage;
            int response;
            do {
                if(guessing){
                    clientMessage = reader.readLine();
                    response = Integer.parseInt(clientMessage);
                    player.SetResponse(response);
                    server.Guess(response, this);
                    guessing = false;
                    server.GetGuessingPlayers();
                }

            } while (!server.IsGameWon());
            this.sendMessage("You won!");
            serverMessage = userName + " quit.";
            server.broadcast(serverMessage);

            server.removeUser(this);
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    void printUsers() {
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }

    @Override
    public void sendMessage(String message) {
        writer.println(message);
    }

    @Override
    public String getUserName() {
        return player.GetName();
    }

    @Override
    public boolean IsGuessing() {
        return guessing;
    }
    
    @Override
    public boolean IsReady(){
        return ready;
    }
    
    @Override
    public void SetGuessing(boolean value){
        this.guessing = value;
    }
}
