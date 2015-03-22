package phoebe.Control;

import phoebe.Model.*;
import phoebe.Model.Robot;

import javax.swing.text.Keymap;
import java.awt.*;
import java.util.Random;

/**
 * Created by andri_000 on 2015.03.07..
 */


/* Az új játék felépítéséért felelős objektum.
   Az inicializálás is itt történik meg.
 */
public class NewGame {

    private Dimension dimension;

    //=============================================================
    //-----------Ideiglenes csak szkeletonos változók--------------
    //=============================================================
    public GameMapContainer gameMap = new GameMapContainer(dimension);
    public GameControl controller = new GameControl(gameMap);

    //=============================================================

    public void initialize(Dimension dimension){
        System.out.println("Init started.");
        this.dimension=dimension;
        addRandomTraps(50);
        gameMap.addRobot(new Robot(new Point(dimension.width - 15, dimension.height - 15), 15, new KeyMap(10, 10, 10, 10, 10, 10)));
        gameMap.addRobot(new Robot(new Point(15, 15), 15, new KeyMap(10,10,10,10,10,10)));
        System.out.println(gameMap.getRobots().size()+ " robots created.");

        System.out.println("Init finished.");
    }
    /**
     * Adds random traps to a GameMapContainer
     * @param {int} count - The number of traps to be added
     */
    public void addRandomTraps(int count){
        Random rndm = new Random();
        for (int i = 0; i < count; i++) {
            rndm.nextInt(2);
            int traptype = rndm.nextInt(2);
            Point loc = new Point(rndm.nextInt(dimension.width), rndm.nextInt(dimension.height));
            try {
                if (traptype == 0) {
                    gameMap.addTrap(new Oil(
                            loc,
                            15) //hitbox
                    );
                    System.out.println("Random-generated oil @ " + loc.x + "x" + loc.y);
                } else {
                    gameMap.addTrap(new Glue(
                            loc,
                            15) //hitbox
                    );
                    System.out.println("Random-generated glue @ " + loc.x + "x" + loc.y);

                }
            }
            catch (Exception e){

                System.out.println(e.toString());
            }

        }

    }

    //Játék kezdése
   /* public void startGame(){

        //gameMap = new GameMapContainer(dimension);//TODO fel kell tölteni a game MAp ot elemekkel !!!!
        controller = new GameControl(gameMap);

    }*/

}
