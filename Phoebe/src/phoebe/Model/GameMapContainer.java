package phoebe.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Geri on 2015.02.19..
 */

/* A játékban a pélyán találhtó objektumok összességének tárolóosztálya.
    Itt tároljuk a robotokat és a csapdákat.
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

    // getterek
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
        System.out.println(""+"    ->[GameMapContainer].addRobot(Robot)"+"" );
        robots.add(robot);
        System.out.println(this.getRobots().size()+ ". robot created.");
    }

    //trap hozzáadása
    public void addTrap(Trap trap) throws Exception {
        System.out.println(""+"    ->[GameMapContainer].addTrap(Trap)"+"" );

    boolean occup = false;
                for (Trap t:traps){
                    //TODO: hitbox
                    if(         trap.location.x < t.location.x+15 && trap.location.x > t.location.x-15
                            &&  trap.location.y < t.location.y+15 && trap.location.y > t.location.y-15 )
                    {
                        occup = true;
                        //throw new Exception("The field is full"); Ez megállítja a játékot!! Nem ez kell nekünk
                        System.out.println("The field is full");
                    }
                }
        if (!occup)
            traps.add(trap);
    }
}
