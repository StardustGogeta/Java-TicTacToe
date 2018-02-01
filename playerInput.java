
/**
 * Write a description of class playerInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class playerInput extends Player
{
    public int id = 1;
    public playerInput(){}
    public playerInput(int id){
        this.id = id;
    }
    int[] getMove(Board board){
        System.out.println(board);
        Scanner input = new Scanner(System.in);
        int x,y;
        boolean check = false;
        do{
            System.out.println("Input your move's \'X\' coordinate");
            x = input.nextInt();
            input.nextLine();
            System.out.println("Input your move's \'Y\' coordinate");
            y = input.nextInt();
            input.nextLine();
            if (board.checkValid(x,y))
                check = true;
        }
        while (!check);
        int[] a = {x,y};
        return a;
    }
    int getID() { return id; }
}
