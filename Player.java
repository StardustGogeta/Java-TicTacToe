
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Player
{
    private int id;
    Player (int name){
        id = name;
    }
    abstract int[] getMove();
}

