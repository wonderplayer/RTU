package com.mycompany.md1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ievadiet speletaju skaitu: ");
        int playerCount = scanner.nextInt();
        int[] playerResponses = new int[2];
        int skaitlis = 1 + (int) (Math.random() * 100);
        boolean exit = false;
        String minejums = "";
        while (!exit) {
            for (int i = 0; i < playerCount; i++) {
                System.out.println("Speletajs " + (i + 1) + " ievadiet skaitli: ");
                playerResponses[i] = scanner.nextInt();
            }
            for (int i = 0; i < playerCount; i++) {
                if (playerResponses[i] > skaitlis) {
                    minejums = "lielāku";
                } else if (playerResponses[i] < skaitlis) {
                    minejums = "mazāku";
                } else {
                    System.out.println("Speletajs " + (i + 1) + " uzmineja!");
                    exit = true;
                    break;
                }
                System.out.println("Speletajs " + (i + 1) + " ievadija " + minejums + " skaitli");
            }
            System.out.println();
        }
    }
}
