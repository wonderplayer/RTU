package com.mycompany.md4server;

public class Player implements IPlayer {

    private int Response;
    private String Name;

    @Override
    public void SetResponse(int response) {
        Response = response;
    }
    
    @Override
    public int GetResponse(){
        return Response;
    }

    @Override
    public String GetName() {
        return Name;
    }

    @Override
    public void SetName(String name) {
        Name = name;
    }
}