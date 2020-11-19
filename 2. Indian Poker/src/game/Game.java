package game;

import java.io.Serializable;

public class Game implements Serializable {
    public int round;

    public Player player1;
    public Player player2;

    public int bet1, bet2;

    public Player p_first; // First player of the round
    public Player p_second; // Second player of the round

    public void printStatus() {
        System.out.println("Round : " + round);
        System.out.println("Player1 : " + player1.toString());
        System.out.println("Player2 : " + player2.toString());
        System.out.println("Bet1 : " + bet1);
        System.out.println("Bet2 : " + bet2);
        System.out.println("First : " + p_first.toString());
        System.out.println("Second : " + p_second.toString());
    }
}
