package com.mycompany.md2;

public class Game {

    private final int RANGE = 100;
    private final int NUMBER = 1 + (int) (Math.random() * RANGE);
    public boolean IsGameWon = false;
    public int Winner;
    
    // Iznest uz šejieni Players. Lai spēle uztur spēlētājus.

    public String Guess(int guess, int player) {
        if (guess < NUMBER) {
            return "mazaku";
        } else if (guess > NUMBER) {
            return "lielaku";
        }
        WinTheGame(player);
        return null;
    }

    private void WinTheGame(int player) {
        IsGameWon = true;
        Winner = player;
        System.out.println("Speletajs " + (player + 1) + " uzmineja!");
    }
}
