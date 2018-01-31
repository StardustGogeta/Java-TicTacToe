
/**
 * Tic-Tac-Toe
 *
 * @author Timmy Beuchel, Chase Fenton, Liam Gerst
 * @version 2-2-18
 */
public class TicTacToe {
    private int sWins = 0, sLosses = 0, sTies = 0, wins = 0, losses = 0, ties = 0;
    
    private Player player1 = new Player(1), player2 = new Player(2);
    // 1 creates a human, 2 creates a random CPU, 3 creates a difficult CPU
    
    private int runGame() {
        Board miniBoard = new Board();
        while (miniBoard.checkVictory() == 0) {
            // Let one player make a move
            // If tie, break
            // Let other player make a move
        }
        // If victory, return code for winning player
        // If tie, return 4
    }
    
    private int runSuperGame() {
        Board superBoard = new Board();
        while (superBoard.checkVictory() == 0) {
            // Run mini-game
            // Check for winner
            // Let winner (if any) make super-move
        }
    }
    
    public static void main (String[] args) {
        System.out.println("MEGA TIC-TAC-TOE\n--------------------------\n"+
        "You must win the \"Grandmaster board\", a normal tic-tac-toe board,\n"+
        "but you can only move after winning a mini-tic-tac-toe game!");
        while (true) {
            superWinner = runSuperGame();
            // Change super W/T/L
            // Prompt to play again
        }
    }
}


