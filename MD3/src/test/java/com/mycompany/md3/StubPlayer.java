package com.mycompany.md3;

public class StubPlayer implements IPlayer{

    private int Response;
    public boolean RespondWasCalled;
    public StubPlayer(){
        Response = 0;
    }
    @Override
    public void Respond() {
        RespondWasCalled = true;
    }

    @Override
    public int GetResponse() {
        return Response++;
    }
    
}
