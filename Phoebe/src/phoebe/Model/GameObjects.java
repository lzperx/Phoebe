package phoebe.Model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Geri on 2015.02.19..
 */
public class GameObjects {
    private List<Robot> robots;
    private List<Trap> traps;
    private GameMap gameMap;
    private Map<String,BufferedImage> Images;



    //Létrehozzuk a megfelelő tárolókat és játék elemeket
    public GameObjects(int width, int high) {
        robots = new ArrayList<Robot>();
        traps = new ArrayList<Trap>();
        gameMap = new GameMap(width, high);
    }
}
