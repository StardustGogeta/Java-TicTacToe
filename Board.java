/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
public class Board
{
    private static final char vertMaster = '‖';
    private static final char horzMaster = '~';
    private static final char vertNormal = '|';
    private static final char horzNormal = '―';
    private static final HashMap<Integer, String> symbols = new HashMap(){{
                put(0, " ");
                put(1, "X");
                put(2, "O");
                put(3, "O");
            }};
            
    private int[][] board = new int[3][3];
    private boolean isMaster;
    public Board(boolean isMaster)
    {
        this.isMaster = isMaster;
    }
    public Board()
    {
        this.isMaster = false;
    }
    /**
     * takes a Player as argument. Requires int id and int[] getMove()
     */
    public void makeMove(Player player)
    {
        int[] move = player.getMove(this);
        int x = move[0], y = move[1];
        assert checkValid(x, y);
        board[y][x] = player.getID();
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
            if(row[0] == row[1] && row[1] == row[2] && row[1] != 0)
                return row[0];
        //check the rowws
        for(int i = 0; i < board[0].length; i++)
        {
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[1][i] != 0)
                return board[0][i];
        }
        //check both diagnols
        if(board[1][1] != 0 && (board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
        board[0][2] == board[1][1] && board[1][1] == board[2][0]))
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
    
    private static String mult(char c, int i)
    {
        return mult(Character.toString(c), i);
    }
    private static String mult(String c, int i)
    {
        String s = "";
        for(int _=0; _<=i; _++)
            s+= c;
        return s;
    }
    public String toString()
    {
        char vert = isMaster ? vertMaster : vertNormal;
        char horz = isMaster ? horzMaster : horzNormal;
        String sep = mult(horz, 7) + "\n";
        String str = sep;
        for(int[] row : board)
        {
            str += vert + symbols.get(row[0]) + vert + symbols.get(row[1]) + vert + symbols.get(row[2]) + vert + "\n";
            str += sep;
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