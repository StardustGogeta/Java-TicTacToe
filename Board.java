
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private int[][] board = new int[3][3];
    
    makeMove(Player player)
    {
        int[] move = player.getMove();
        x = move[0]; y = move[1];
        if (checkValid(x, y))
            board[x][y] = player.id;
    }
    boolean checkVictory()
    private boolean checkValid(int x, int y)
    public String toString();
}

/** player
 * getMove()
 * int id
 */