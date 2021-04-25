package com.mycompany.md3;

import java.util.Scanner;

public class Main {

    private static final Scanner Scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
    }
}
