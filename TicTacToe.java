import java.util.Scanner;
/**
 * Tic-Tac-Toe
 *
 * @author Timmy Beuchel, Chase Fenton, Liam Gerst
 * @version 2-5-18
 */
public class TicTacToe {
    private static int sWins = 0, sLosses = 0, sTies = 0, wins = 0, losses = 0, ties = 0;
    private static boolean pvp = false;
    private final static int PLAYER1_ID = 1, PLAYER2_ID = 2, TIE_ID = -1;
    private static Player player1, player2;
    // 1 creates a human, 2 creates a random CPU, 3 creates a difficult CPU

    private static int runGame() {
        System.out.println("Mini-Game Record (for Player 1):\nW: " + wins + "\tT: " + ties + "\tL: " + losses);
        if (pvp) System.out.println("Mini-Game Record (for Player 2):\nW: " + losses + "\tT: " + ties + "\tL: " + wins);
        Board miniBoard = new Board();
        int victory = 0;
        int move[];
        System.out.println("\nTime for a mini-game!");
        while (true) {
            // Let one player make a move
            miniBoard.makeMove(player1);
            victory = miniBoard.checkVictory();
            if (victory != 0) {
                System.out.println("FINAL MINI-BOARD:\n" + miniBoard);
                return victory;
            }
            // Let other player make a move
            miniBoard.makeMove(player2);
            victory = miniBoard.checkVictory();
            if (victory != 0) {
                System.out.println("FINAL MINI-BOARD:\n" + miniBoard);
                return victory;
            }
        }
    }

    private static int runSuperGame() {
        System.out.println("Grandmaster Record (for Player 1):\nW: " + sWins + "\tT: " + sTies + "\tL: " + sLosses);
        if (pvp) System.out.println("Grandmaster Record (for Player 2):\nW: " + sLosses + "\tT: " + sTies + "\tL: " + sWins);
        Board superBoard = new Board(true);
        int move[];
        while (superBoard.checkVictory() == 0) {
            // Run mini-game
            int winner = runGame();
            if (winner != TIE_ID) {
                if (winner == PLAYER1_ID) {
                    wins++;
                    System.out.println("\nPlayer 1 won!\nTime to make a move on the Grandmaster Board!");
                    superBoard.makeMove(player1);
                }
                else {
                    losses++;
                    System.out.println("\nPlayer 2 won!\nTime to make a move on the Grandmaster Board!");
                    superBoard.makeMove(player2);
                }
            }
            else {
                ties++;
                System.out.println("It's a tie! Time to play again!");
            }
            System.out.println("Grandmaster Board:\n" + superBoard);
        }
        return superBoard.checkVictory();
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("MEGA TIC-TAC-TOE\n--------------------------\n"+
            "You must win the \"Grandmaster board\", a normal tic-tac-toe board,\n"+
            "but you can only move after winning a mini-tic-tac-toe game!\n");
        System.out.println("Select a game setup:\n 1 - Player vs. Player\n 2 - Player vs Easy CPU\n 3 - Player vs Hard CPU");
        while (true) {
            int res = scan.nextInt();
            if (res == 1234) { // Easter-egg!
                player1 = new easyBot(PLAYER1_ID);
                player2 = new hardBot(PLAYER2_ID);
                break;
            }
            if (res == 2187) { // Easter-egg 2!
                player1 = new hardBot(PLAYER1_ID);
                player2 = new hardBot(PLAYER2_ID);
                break;
            }
            if (res < 4 && res > 0) {
                if (res == 1) {
                    player1 = new playerInput(PLAYER1_ID);
                    player2 = new playerInput(PLAYER2_ID);
                    pvp = true;
                }
                else if (res == 2) {
                    player1 = new playerInput(PLAYER1_ID);
                    player2 = new easyBot(PLAYER2_ID);
                }
                else {
                    player1 = new playerInput(PLAYER1_ID);
                    player2 = new hardBot(PLAYER2_ID);
                }
                break;
            }
            else { System.out.println("Please try again."); }
        }
        while (true) {
            int superWinner = runSuperGame();

            if (superWinner == 1) { sWins++; System.out.println("You won!"); }
            else if (superWinner == TIE_ID) sTies++;
            else sLosses++;

            System.out.println("Grandmaster Record (for Player 1):\nW: " + sWins + "\tT: " + sTies + "\tL: " + sLosses);
            if (pvp) System.out.println("Grandmaster Record (for Player 2):\nW: " + sLosses + "\tT: " + sTies + "\tL: " + sWins);
            System.out.println("Would you like to play again? (Y=0)");
            if (scan.nextInt() != 0) break;
        }
        System.out.println("Thanks for playing!");
    }
}

