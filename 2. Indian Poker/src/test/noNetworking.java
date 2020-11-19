package test;

import java.util.Scanner;
import game.*;

public class noNetworking {
    public static void main(String[] args) {
        final int startChips = 20;

        Scanner scanner = new Scanner(System.in);

        // Input player name
        System.out.print("Player1 name: ");
        String name1 = scanner.nextLine();
        System.out.print("Player2 name: ");
        String name2 = scanner.nextLine();

        System.out.println("\n");

        /* Decide the first player with rock scissor paper */

        // Player1 starts first
        Player player1 = new Player(name1, startChips); player1.lastWin = true;
        Player player2 = new Player(name2, startChips); player2.lastWin = false;
        Deck deck = new Deck();

        // 10 rounds
        for(int round=1; round<=10; round++) {
            System.out.println("Round: " + round + "\n");

            if(player1.totalChips == 2*startChips || player2.totalChips == 2*startChips) {
                break;
            }

            // Match player1, player2 with f_player, s_player
            int first, second;
            Player f_player, s_player;
            if(player1.lastWin) {
                first = 1; second = 2;
                f_player = player1;
                s_player = player2;
            } else {
                first = 2; second = 1;
                f_player = player2;
                s_player = player1;
            }

            // Draw cards
            f_player.myCard = deck.drawCard();
            s_player.myCard = deck.drawCard();

            int bet1 = 0, bet2 = 0;

            // Basic betting
            f_player.betChips(1);
            s_player.betChips(1);

            while(true) {
                // Betting of each player of this round
                System.out.println("Player" + first + "'s total betting: " + f_player.bettingChips);
                System.out.println("Player" + second + "'s total betting: " + s_player.bettingChips);
                System.out.println();

                // Bet until it satisfies the rule
                do {
                    System.out.print("Player" + first + " bets(enter 0 for giving up): ");
                    bet1 = scanner.nextInt(); // First player bets
                } while(f_player.bettingChips + bet1 < s_player.bettingChips && bet1 != 0);
                f_player.betChips(bet1);

                // First player gives up
                if(bet1 == 0) {
                    f_player.moreBet = false;
                    break;
                }
                // First player
                // Total betting is same
                else if(f_player.bettingChips == s_player.bettingChips) {
                    break;
                }

                System.out.println("Player" + first + "'s total betting: " + f_player.bettingChips);
                System.out.println("Player" + second + "'s total betting: " + s_player.bettingChips);
                System.out.println();

                // Bet until it satisfies the rule
                do {
                    System.out.print("Player" + second + " bets(enter 0 for giving up): ");
                    bet2 = scanner.nextInt(); // Second player bets
                } while(s_player.bettingChips + bet2 < f_player.bettingChips && bet2 != 0);
                s_player.betChips(bet2);

                // Second player gives up
                if(bet2 == 0) {
                    s_player.moreBet = false;
                    break;
                }
                // Total betting is same
                else if(f_player.bettingChips == s_player.bettingChips) {
                    break;
                }
            }
            System.out.println("Player1's card: " + player1.myCard.toString());
            System.out.println("Player2's card: " + player2.myCard.toString());

            Player winner = null, loser = null;
            boolean tie = false;

            // First player gives up
            if(!f_player.moreBet) {
                if(f_player.myCard.face == 10) {
                    f_player.totalChips -= 10;
                    s_player.totalChips += 10;
                }
                winner = s_player;
                loser = f_player;
            }
            // Second player gives up
            else if(!s_player.moreBet) {
                if(s_player.myCard.face == 10) {
                    s_player.totalChips -= 10;
                    f_player.totalChips += 10;
                }
                winner = f_player;
                loser = s_player;
            }
            // Total betting is same
            else {
                // First player has higher value
                if(f_player.myCard.face > s_player.myCard.face) {
                    winner = f_player;
                    loser = s_player;
                }
                // Second player has higher value
                else if(s_player.myCard.face > f_player.myCard.face) {
                    winner = s_player;
                    loser = f_player;
                }
                // Tie
                else {
                    tie = true;
                }
            }

            // No tie
            if(!tie) {
                winner.win(loser.bettingChips);
                loser.lose();
            }
            // Tie
            else {
                f_player.moreBet = true;
                s_player.moreBet = true;
            }

            // Result of one round
            System.out.println("Player1: " + player1.totalChips);
            System.out.println("Player2: " + player2.totalChips);
            System.out.println("\n");
        }

        // Final result
        System.out.println("Player1: " + player1.totalChips);
        System.out.println("Player2: " + player2.totalChips);
    }
}
