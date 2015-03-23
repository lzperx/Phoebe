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

    public Dimension dimension; //todo visszaírni private-ra

    //=============================================================
    //-----------Ideiglenes csak szkeletonos változók--------------
    //=============================================================
    public GameMapContainer gameMap = new GameMapContainer(dimension);
    public GameControl controller = new GameControl(gameMap);

    //=============================================================

    public void initialize(Dimension dimension){
        System.out.println(""+"    ->[NewGame].initialize()"+"");

        this.dimension=dimension;
        addRandomTraps(20);
        gameMap.addRobot(new Robot(new Point(dimension.width - 150, dimension.height - 150), 15, new KeyMap(10, 10, 10, 10, 10, 10)));
        gameMap.addRobot(new Robot(new Point(150, 150), 15, new KeyMap(10,10,10,10,10,10)));

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
                    System.out.println(i+1+": Random-generated oil @ " + loc.x + "x" + loc.y);
                } else {
                    gameMap.addTrap(new Glue(
                            loc,
                            15) //hitbox
                    );
                    System.out.println(i+1+": Random-generated glue @ " + loc.x + "x" + loc.y);

                }
            }
            catch (Exception e){

                System.out.println(e.toString());
                i--;
            }

        }

    }

    //Játék kezdése
   /* public void startGame(){

        //gameMap = new GameMapContainer(dimension);//TODO fel kell tölteni a game MAp ot elemekkel !!!!
        controller = new GameControl(gameMap);

    }*/

}
