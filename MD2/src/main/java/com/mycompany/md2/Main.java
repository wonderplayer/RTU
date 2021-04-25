package com.mycompany.md2;

public class Main {

    public static void main(String[] args) {
        String minejums;
        Users users = new Users();
        Game game = new Game();

        users.InitializePlayers();
        while (!game.IsGameWon) {
            for (int i = 0; i < users.GetPlayerCount(); i++) {
                users.Respond(i);
            }
            for (int i = 0; i < users.GetPlayerCount(); i++) {
                minejums = game.Guess(users.GetPlayerResponse(i), i);
                if (minejums == null) {
                    break;
                }
                System.out.println("Speletajs " + (i + 1) + " ievadija " + minejums + " skaitli");
            }
            System.out.println();
        }
    }
}
