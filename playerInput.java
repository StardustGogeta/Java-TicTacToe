
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
        int y, x;
        boolean check = false;
        do{
            System.out.println("Input your move's \'X\' coordinate");
            x = input.nextInt();
            input.nextLine();
            System.out.println("Input your move's \'Y\' coordinate");
            y = input.nextInt();
            input.nextLine();
            if (board.checkValid(y, x))
                check = true;
            else System.out.println("Invalid coordinates!\nTry again!");
        }
        while (!check);
        int[] a = {y, x};
        return a;
    }
    int getID() { return id; }
}
