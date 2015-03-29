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



    private List<CleanerRobot> cleanerRobots;
    private List<PlayerRobot> playerRobots;
    private List<Trap> traps;
    private Map<String,BufferedImage> Images;


    //Létrehozzuk a megfelelő tárolókat és játék elemeket
    public GameMapContainer(Dimension resolution) {
        this.resolution = resolution;
        playerRobots = new ArrayList<PlayerRobot>();
        traps = new ArrayList<Trap>();
    }

    // getterek
    public List<PlayerRobot> getPlayerRobots() {
        return playerRobots;
    }

    public List<CleanerRobot> getCleanerRobots() {
        return cleanerRobots;
    }

    public List<Trap> getTraps() {
        return traps;
    }

    public Map<String, BufferedImage> getImages() {
        return Images;
    }

    //robot hozzáadása
    public void addRobot(PlayerRobot playerRobot) {
        System.out.println(""+"    ->[GameMapContainer].addRobot(Robot)"+"" );
        playerRobots.add(playerRobot);
        System.out.println(this.getPlayerRobots().size()+ ". robot created.");
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
