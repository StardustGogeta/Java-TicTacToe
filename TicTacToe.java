import java.util.Scanner;
/**
 * Tic-Tac-Toe
 *
 * @author Timmy Beuchel, Chase Fenton, Liam Gerst
 * @version 2-5-18
 */
public class TicTacToe {
    private static int sWins = 0, sLosses = 0, sTies = 0, wins = 0, losses = 0, ties = 0;

    private final static int PLAYER1_ID = 1, PLAYER2_ID = 2, TIE_ID = -1;
    private static Player player1 = new easyBot(PLAYER1_ID), player2 = new easyBot(PLAYER2_ID);
    // 1 creates a human, 2 creates a random CPU, 3 creates a difficult CPU

    private static int runGame() {
        System.out.println("Mini-Game Record:\nW: " + wins + "\tT: " + ties + "\tL: " + losses);
        Board miniBoard = new Board();
        int victory = 0;
        int move[];
        System.out.println("start of game");
        while (true) {
            // Let one player make a move
            miniBoard.makeMove(player1);
            victory = miniBoard.checkVictory();
            if (victory != 0) return victory;
            // Let other player make a move
            miniBoard.makeMove(player2);
            victory = miniBoard.checkVictory();
            if (victory != 0) {
                System.out.println("end of game");
                return victory;
            }
        }
    }

    private static int runSuperGame() {
        System.out.println("Grandmaster Record:\nW: " + sWins + "\tT: " + sTies + "\tL: " + sLosses);
        Board superBoard = new Board();
        int move[];
        while (superBoard.checkVictory() == 0) {
            // Run mini-game
            int winner = runGame();
            System.out.println("YAY!");
            if (winner != TIE_ID) {
                if (winner == PLAYER1_ID) {
                    wins++;
                    superBoard.makeMove(player1);
                }
                else {
                    losses++;
                    superBoard.makeMove(player2);
                }
            }
            else {
                ties++;
                System.out.println("It's a tie! Time to play again!");
            }
        }
        return superBoard.checkVictory();
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("MEGA TIC-TAC-TOE\n--------------------------\n"+
            "You must win the \"Grandmaster board\", a normal tic-tac-toe board,\n"+
            "but you can only move after winning a mini-tic-tac-toe game! "+player1.getID());
        while (true) {
            int superWinner = runSuperGame();
            
            if (superWinner == 1) { sWins++; System.out.println("You won!"); }
            else if (superWinner == TIE_ID) sTies++;
            else sLosses++;
            
            System.out.println("Grandmaster Record:\nW: " + sWins + "\tT: " + sTies + "\tL: " + sLosses);
            System.out.println("Would you like to play again? (Y=0)");
            if (scan.nextInt() != 0) break;
        }
        System.out.println("Thanks for playing!");
    }
}

