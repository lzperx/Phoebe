package phoebe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geri on 2015.02.19..
 */
public class GameElements {
    private List<Robot> robots;
    private List<Trap> traps;
    private Map map;


    //Létrehozzuk a megfelelő tárolókat és játék elemeket
    public GameElements(int width,int high) {
        robots = new ArrayList<Robot>();
        traps = new ArrayList<Trap>();
        map = new Map(width, high);
    }
}
