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
    private List<Glue> glues;
    private List<Oil> oils;
    private GameMap gameMap;
    private Map<String,BufferedImage> Images;



    //Létrehozzuk a megfelelő tárolókat és játék elemeket
    public GameObjects(int width, int  height) {
        robots = new ArrayList<Robot>();
        glues = new ArrayList<Glue>();
        oils= new ArrayList<Oil>();
        gameMap = new GameMap(width, height);

    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Glue> getGlues() {
        return glues;
    }

    public List<Oil> getOils() {
        return oils;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Map<String, BufferedImage> getImages() {
        return Images;
    }

    //robot hozzáadása
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    //ragacs hozzáadása
    public void addGlue(Glue glue) {
        glues.add(glue);
    }

    //olajfolt hozzáadása
    public void addOil(Oil oil) {
        oils.add(oil);
    }


}
