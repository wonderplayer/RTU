package com.mycompany.md3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    public GameTest() {
    }

    private StubPlayer[] InitializeStubPlayers() {
        StubPlayer[] players = new StubPlayer[10];
        for (int i = 0; i < players.length; i++) {
            players[i] = new StubPlayer();
        }
        return players;
    }

    @Test
    public void IsGameWon_NoResponsesEntered_False() {
        IPlayer[] players = InitializeStubPlayers();
        Game instance = new Game(players);
        boolean expResult = false;
        boolean result = instance.IsGameWon();
        assertEquals(expResult, result);
    }

    @Test
    public void IsGameWon_CorrectResponseGuessed_True() {
        IPlayer[] players = InitializeStubPlayers();
        Game instance = new Game(players);

        for (int i = 0; i < 100; i++) {
            instance.GetPlayerResponses();
            instance.ProcessPlayerResponses();
            if (instance.IsGameWon()) {
                return;
            }
        }
        fail("Correct response was not recorded.");
    }

    @Test
    public void GetPlayerResponse_AllHaveResponded_True() {
        StubPlayer[] players = InitializeStubPlayers();
        Game instance = new Game(players);
        instance.GetPlayerResponses();
        for(int i = 0; i < players.length; i++){
            if(!players[i].RespondWasCalled){
                fail("Repond() function was not called for " + (i + 1) + " player.");
            }
        }
    }

    @Test
    public void ProcessPlayerResponses_PlayerOneHasRespondedWithLessNumber_True() {
        StubPlayer[] players = new StubPlayer[1];
        players[0] = new StubPlayer();
        Game instance = new Game(players);
        
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        instance.ProcessPlayerResponses();
        System.setOut(standardOut);

        assertEquals("Speletajs 1 ievadija mazaku skaitli", outputStreamCaptor.toString().trim());
    }
}
