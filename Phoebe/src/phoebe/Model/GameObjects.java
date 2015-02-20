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
    public GameObjects() {
        robots = new ArrayList<Robot>();
        traps = new ArrayList<Trap>();
        gameMap = new GameMap(500, 500);

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


    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void addTrap(Trap trap) {
        traps.add(trap);
    }


    public void setControlKeys(List<Keyboard> controlKeys) {
        this.controlKeys = controlKeys;
    }
}
