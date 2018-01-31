
/**
 * Tic-Tac-Toe
 *
 * @author Timmy Beuchel, Chase Fenton, Liam Gerst
 * @version 2-5-18
 */
public class TicTacToe {
    private int sWins = 0, sLosses = 0, sTies = 0, wins = 0, losses = 0, ties = 0;

    private final static int PLAYER1_ID = 1, PLAYER2_ID = 2, TIE_ID = 4;
    private static Player player1 = new Player(PLAYER1_ID), player2 = new Player(PLAYER2_ID);
    // 1 creates a human, 2 creates a random CPU, 3 creates a difficult CPU

    private static int runGame() {
        Board miniBoard = new Board();
        int victory = 0;
        int move[];
        while (true) {
            // Let one player make a move
            move = player1.getMove();
            miniBoard.makeMove(move);
            victory = miniBoard.checkVictory();
            if (victory > 0) return victory;
            // Let other player make a move
            move = player2.getMove();
            miniBoard.makeMove(move);
            victory = miniBoard.checkVictory();
            if (victory > 0) return victory;
        }
    }

    private static int runSuperGame() {
        Board superBoard = new Board();
        int move[];
        while (superBoard.checkVictory() == 0) {
            // Run mini-game
            int winner = runGame();
            if (winner != TIE_ID) {
                if (winner == PLAYER1_ID) move = player1.getMove();
                else move = player2.getMove();
                superBoard.makeMove(move);
            }
            else System.out.println("It's a tie! Time to play again!");
        }
        return superBoard.checkVictory();
    }

    public static void main (String[] args) {
        System.out.println("MEGA TIC-TAC-TOE\n--------------------------\n"+
            "You must win the \"Grandmaster board\", a normal tic-tac-toe board,\n"+
            "but you can only move after winning a mini-tic-tac-toe game!");
        while (true) {
            int superWinner = runSuperGame();
            // Change super W/T/L
            // Prompt to play again
        }
    }
}

