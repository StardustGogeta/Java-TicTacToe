
/**
 * Write a description of class hardBot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 * to do:
 * astetically change grand master board
 */
public class hardBot extends Player
{
    private static easyBot easy = new easyBot(500);
    public int id = 3;
    /**
     * constructors
     */
    public hardBot(){}
    public hardBot(int id)
    {
        this.id = id;
    }
    
    public int[] getMove(Board boardy)
    {
        int[][] board = boardy.getBoard();
        //check if there are any 2 in a row on the board
        int[] move = checkBoard(board);
        if(move != null)
            return move;
        else
            return easy.getMove(boardy);
    }

    /**
     * Checks the board for any two in a line
     * Returns the space a move must be made in, if it exists (x, y)
     * currently only detects 2 in a row, not when the middle can be completed (fix later)
     * carefully test for switching of x and y
     * add checking for 0. 
     */
    private int[] checkBoard(int[][] board)
    {
        //collumns
        for(int i=0; i<board.length; i++)
            if(board[i][0] == board[i][1])
                return new int[]{2, i};
            else if(board[i][1] == board[i][2])
                return new int[]{0, i};
        //rowws
        for(int i = 0; i < board[0].length; i++)
        {
            if(board[0][i] == board[1][i])
                return new int[]{2, i};
            else if (board[1][i] == board[2][i])
                return new int[]{0, i};
        }
        //diagnols
        if(board[0][0] == board[1][1])
            return new int[]{2, 2};
        else if (board[1][1] == board[2][2])
            return new int[]{0, 0};
        else if (board[0][2] == board[1][1])
            return new int[]{0, 2};
        else if(board[1][1] == board[2][0])
            return new int[] {2, 0};
        
        //nothing applies
        return null;
    }
    
    public int getID()
    {
        return id;
    }
}
