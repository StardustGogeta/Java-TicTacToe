/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
public class Board
{
    private int[][] board = new int[3][3];
    private static HashMap<Integer, String> symbols = new HashMap(){{
        put(0, " ");
        put(1, "X");
        put(2, "O");
        put(3, "O");
    }};
    public void makeMove(Player player)
    {
        int[] move = player.getMove();
        int x = move[0], y = move[1];
        if (checkValid(x, y))
            board[x][y] = player.id;
    }
    public int checkVictory()
    {
        //check the rows
        for(int[] row : board)
            if(row[0] == row[1] && row[1] == row[2])
                return row[0];
        //check the collumns
        for(int i = 0; i < board[0].length; i++)
        {
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        //check both diagnols
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
           board[0][2] == board[1][1] && board[1][1] == board[2][0])
           return board[1][1];
        //tie
        return 4;
    }
    private boolean checkValid(int x, int y)
    {
        return board[x][y] == 0;
    }
    public String toString()
    {
        String str = "-------\n";
        for(int[] row : board)
        {
            str += "|" + symbols.get(row[0]) + "|" + symbols.get(row[1]) + "|" + symbols.get(row[2]) + "|\n";
            str += "-------\n";
        }
        return str;
    }
}

/** player
 * getMove()
 * int id
 */