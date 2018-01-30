
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private int[][] board = new int[3][3];
    private static HashMap<String, Integer> map = new HashMap<>()
    public void makeMove(Player player)
    {
        int[] move = player.getMove();
        x = move[0]; y = move[1];
        if (checkValid(x, y))
            board[x][y] = player.id;
    }
    public int checkVictory()
    {
        //return 4 if tie
    }
    private boolean checkValid(int x, int y)
    {
        return board[x][y] == 0;
    }
    public String toString()
    {
        String str = "---------\n" +
        
    }
}

/** player
 * getMove()
 * int id
 */