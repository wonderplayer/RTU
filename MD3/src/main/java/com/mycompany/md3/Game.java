package com.mycompany.md3;

public class Game {

    private final int RANGE = 100;
    private final int NUMBER = 1 + (int) (Math.random() * RANGE);
    private boolean IsGameWon = false;
    private int WinnerIndex;
    private final IPlayer[] Players;

    public Game(IPlayer[] players){
        Players = players;
    }
    
    private void PrintIncorrectGuess(int player, String guess) {
        System.out.println("Speletajs " + (player + 1) + " ievadija " + guess + " skaitli");
    }

    private void Guess(int guess, int player) {
        if (guess < NUMBER) {
            PrintIncorrectGuess(player, "mazaku");
        } else if (guess > NUMBER) {
            PrintIncorrectGuess(player, "lielaku");
        } else {
            WinTheGame(player);
        }
    }

    private void WinTheGame(int player) {
        IsGameWon = true;
        WinnerIndex = player;
        System.out.println("Speletajs " + (player + 1) + " uzmineja!");
    }

    public boolean IsGameWon() {
        return IsGameWon;
    }

    public void GetPlayerResponses() {
        for (int i = 0; i < Players.length; i++) {
            System.out.println("Speletajs " + (i + 1) + " ievadiet skaitli: ");
            Players[i].Respond();
        }
    }

    public void ProcessPlayerResponses() {
        IPlayer player;
        for (int i = 0; i < Players.length; i++) {
            player = Players[i];
            Guess(player.GetResponse(), i);
        }
        System.out.println();
    }
}
