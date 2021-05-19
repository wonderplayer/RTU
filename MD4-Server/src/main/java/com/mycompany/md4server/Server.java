package com.mycompany.md4server;

import java.util.Scanner;

public class Server {

    private static final Scanner Scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Connection server = new Connection(9876);
        server.execute();
/*
        System.out.println("Ievadiet speletaju skaitu:");
        int playerCount = Scanner.nextInt();
        Player[] players = new Player[playerCount];
        for(int i = 0; i < playerCount; i++){
            players[i] = new Player();
        }
        Game game = new Game(players);

        while (!game.IsGameWon()) {
            game.GetPlayerResponses();
            game.ProcessPlayerResponses();
        }
*/
    }
}
