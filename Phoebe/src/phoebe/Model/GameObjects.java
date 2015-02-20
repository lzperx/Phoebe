package phoebe.Model;

import java.awt.image.BufferedImage;
import java.sql.Struct;
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
    private List<Keyboard> controlKeys;    // minden robothoz jár egy irányítás





    //Létrehozzuk a megfelelő tárolókat és játék elemeket
    public GameObjects(int width, int high) {
        robots = new ArrayList<Robot>();
        traps = new ArrayList<Trap>();
        gameMap = new GameMap(width, high);

    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Trap> getTraps() {
        return traps;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Map<String, BufferedImage> getImages() {
        return Images;
    }
}
