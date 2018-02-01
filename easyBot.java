
/**
 * Write a description of class easyBot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class easyBot extends Player
{
    public int id = 2;
    public easyBot(){}
    public easyBot(int id){
        this.id = id;
    }
    int[] getMove(Board board){
        Random rand = new Random();
        while(true){
            int x = rand.nextInt(3);
            int y = rand.nextInt(3);
            if (board.checkValid(x,y)){
                return new int[] {x,y};
            }
        } 
    }
    int getID() { return id; }
}
