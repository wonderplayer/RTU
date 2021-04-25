package com.mycompany.md2;

import java.util.Scanner;

public class Users {

    // Users būs tikai viens konkrēts Player.
    private int[] Players;
    private final Scanner Scanner;

    public Users() {
        Scanner = new Scanner(System.in);
    }

    public void InitializePlayers() {
        System.out.println("Ievadiet speletaju skaitu: ");
        Players = new int[Scanner.nextInt()];
    }

    public void Respond(int player) {
        System.out.println("Speletajs " + (player + 1) + " ievadiet skaitli: ");
        Players[player] = Scanner.nextInt();
    }

    public int GetPlayerCount() {
        return Players.length;
    }

    public int GetPlayerResponse(int player) {
        return Players[player];
    }
}
