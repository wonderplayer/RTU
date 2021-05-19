package com.mycompany.md4server;
import java.io.*;
import java.net.*;
import java.util.*;

public class Connection {
    private int port;
    private Set<IUserThread> userThreads = new HashSet<>();
    private final int RANGE = 100;
    private final int NUMBER = 1 + (int) (Math.random() * RANGE);
    private boolean IsGameWon = false;
    private IUserThread Winner;
 
    public Connection(int port) {
        this.port = port;
    }
 
    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Chat Server is listening on port " + port);
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
 
                IUserThread newUser = new UserThread(socket, this, new Player());
                userThreads.add(newUser);
                new Thread(newUser).start();
            }
 
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    void broadcast(String message) {
        for (IUserThread aUser : userThreads) {
            aUser.sendMessage(message);
        }
    }
 
    void removeUser(UserThread aUser) {
        userThreads.remove(aUser);
        System.out.println("The user " + aUser.getUserName() + " quitted");
    }
 
    Set<String> getUserNames() {
        Set<String> names = new HashSet<String>();
        for(IUserThread userThread : userThreads){
            names.add(userThread.getUserName());
        }
        
        return names;
    }
 
    boolean hasUsers() {
        return !(this.userThreads.size() == 1);
    }
    
    public void GetGuessingPlayers(){
        Set<String> names = new HashSet<>();
        Set<IUserThread> answeredUsers = new HashSet<>();
        for (IUserThread user : userThreads){
            if(user.IsGuessing()){
                names.add(user.getUserName());
            }
            else {
                answeredUsers.add(user);
            }
        }
        if(names.isEmpty()){
            for(IUserThread user : userThreads){
                user.SetGuessing(true);
            }
        }
        else {
            for(IUserThread user : answeredUsers){
                user.sendMessage("Players " + names + " are still guessing...");
            }
        }
    }
    
    public boolean CheckReady(){
        boolean playersAreReady = true;
        for(IUserThread user : userThreads){
            if(!user.IsReady()){
                playersAreReady = false;
            }
        }
        if(playersAreReady){
            this.broadcast("Let's start!");
        }
        return playersAreReady;
    }
    
    private void OutputIncorrectGuess(IUserThread player, String guess) {
        player.sendMessage("You have input " + guess + " number");
    }

    public void Guess(int guess, IUserThread user) {
        if (guess < NUMBER) {
            OutputIncorrectGuess(user, "smaller");
        } else if (guess > NUMBER) {
            OutputIncorrectGuess(user, "bigger");
        } else {
            WinTheGame(user);
        }
    }

    private void WinTheGame(IUserThread user) {
        IsGameWon = true;
        Winner = user;
        this.broadcast("Player " + user.getUserName() + " won!");
    }

    public boolean IsGameWon() {
        return IsGameWon;
    }
}