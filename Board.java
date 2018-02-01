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
    /**
     * takes a Player as argument. Requires int id and int[] getMove()
     */
    public void makeMove(Player player)
    {
        int[] move = player.getMove(this);
        int x = move[0], y = move[1];
        assert checkValid(x, y);
        board[y][x] = player.id;
    }

    /**
     * returns:
     * 0 : moves still avilable, no victory
     * 1, 2, 3 : id of victor
     * -1 : tie
     */
    public int checkVictory()
    {
        //check the collums
        for(int[] row : board)
            if(row[0] == row[1] && row[1] == row[2])
                return row[0];
        //check the rowws
        for(int i = 0; i < board[0].length; i++)
        {
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        //check both diagnols
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
        board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[1][1];
        //check if moves can be made
        for(int[] row : board)
            for(int space : row)
                if(space == 0)
                    return 0;
        //tie
        return -1;
    }

    public boolean checkValid(int x, int y)
    {
        return board[y][x] == 0;
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

    public int[][] getBoard()
    {
        return board;
    }
}

/** player
 * getMove()
 * int id
 */