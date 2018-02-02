
/**
 * Write a description of class hardBot here.
 *
 * @author (your name)
 * @version (a version number or a date)

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
     * carefully test for switching of x and y

     */
    private int[] checkBoard(int[][] board)
    {
        // columns
        for(int i=0; i<board.length; i++)
            if(board[i][0] == board[i][1] && board[i][2] == 0 && board[i][0] != 0)
                return new int[]{2, i};
            else if(board[i][1] == board[i][2] && board[i][0] == 0 && board[i][1] != 0)
                return new int[]{0, i};
            //check space in between
            else if(board[i][0] == board[i][2] && board[i][0] != 0 && board[i][1] == 0)
                return new int[]{1, i};
        // rows
        for(int i = 0; i < board[0].length; i++)
        {
            if(board[0][i] == board[1][i] && board[2][i] == 0 && board[0][i] != 0)
                return new int[]{i, 2};
            else if (board[1][i] == board[2][i] && board[0][i] == 0 && board[1][i] != 0)
                return new int[]{i, 0};
            // check space in between
            else if (board[0][i] == board[2][i] && board[1][i] == 0 && board[0][1] != 0)
                return new int[]{1, 0};
        }
        // diagonals
        if(board[0][0] == board[1][1] && board[2][2] == 0 && board[0][0] != 0)
            return new int[]{2, 2};
        else if (board[1][1] == board[2][2] && board[0][0] == 0 && board[1][1] != 0)
            return new int[]{0, 0};
        else if (board[0][2] == board[1][1] && board[2][0] == 0 && board[0][2] != 0)
            return new int[]{0, 2};
        else if(board[1][1] == board[2][0] && board[0][2] == 0 && board[1][1] != 0)
            return new int[] {2, 0};
        //don't need to check space in between because middle space is claimed later if possible. 
        
        //claim middle space if possible
        if (board[1][1] == 0)
            return new int[] {0, 0};
            
        //nothing applies
        return null;
    }
    
    public int getID()
    {
        return id;
    }
}
