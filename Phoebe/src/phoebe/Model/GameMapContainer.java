package phoebe.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Geri on 2015.02.19..
 */
public class GameMapContainer {

    // Pálya felbontása
    Dimension resolution;

    private List<Robot> robots;
    private List<Trap> traps;
    private Map<String,BufferedImage> Images;


    //Létrehozzuk a megfelelő tárolókat és játék elemeket
    public GameMapContainer(Dimension resolution) {
        this.resolution = resolution;
        robots = new ArrayList<Robot>();
        traps = new ArrayList<Trap>();
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Trap> getTraps() {
        return traps;
    }

    public Map<String, BufferedImage> getImages() {
        return Images;
    }

    //robot hozzáadása
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    //trap hozzáadása
    public void addTrap(Trap trap) {
        traps.add(trap);
    }

}
