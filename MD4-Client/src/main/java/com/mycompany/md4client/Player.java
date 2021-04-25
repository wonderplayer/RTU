package com.mycompany.md4client;

import java.util.Scanner;

public class Player implements IPlayer {

    private final Scanner Scanner= new Scanner(System.in);
    private int Response;

    @Override
    public void Respond() {
        Response =  Scanner.nextInt();
    }
    
    @Override
    public int GetResponse(){
        return Response;
    }
}