package phoebe.Control;

import phoebe.Model.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Muresan73 on 15. 02. 20..
 */

/*A teljes játékirányításért felelős objektum.*/
public class GameControl implements KeyListener {

    /*   Referencia a játékelemeket tároló objektumra,
     *   így tudjuk hogy milyen robotok vannak, és mi hol van a pályán.
     *   Ezt a konstruktorban kell átadni.
    */
    private GameMapContainer gameMapContainer;

    public GameControl(GameMapContainer gameMapContainer) {
        this.gameMapContainer = gameMapContainer;
    }

    private final Timer timer =new Timer();


    /* gomblenyomások érzékelése, és a megfelelő gombhoz tartozó
     * boolean változó true ra állítása.
    */
    @Override
    public void keyPressed(KeyEvent e) {

        for (Robot R2D2: gameMapContainer.getRobots()) {

            if(e.getKeyCode()== R2D2.keys.getLeftKey())
                R2D2.keys.left=true;
            if(e.getKeyCode() == R2D2.keys.getUpKey())
                R2D2.keys.up=true;
            if(e.getKeyCode() == R2D2.keys.getRightKey())
                R2D2.keys.right=true;
            if(e.getKeyCode() == R2D2.keys.getDownKey())
                R2D2.keys.down=true;
            if(e.getKeyCode() == R2D2.keys.getOilKey())
                R2D2.keys.oil= true;
            if(e.getKeyCode() == R2D2.keys.getGlueKey())
                R2D2.keys.glue= true;
        }
    }


    /*  gomb felengedésének érzékelése, és
     *  a megfelelő gomb boolean változójának false ra állítása.
    */
    @Override
    public void keyReleased(KeyEvent e) {

        for (Robot R2D2: gameMapContainer.getRobots()) {

            if(e.getKeyCode()== R2D2.keys.getLeftKey())
                R2D2.keys.left=false;
            if(e.getKeyCode() == R2D2.keys.getUpKey())
                R2D2.keys.up=false;
            if(e.getKeyCode() == R2D2.keys.getRightKey())
                R2D2.keys.right=false;
            if(e.getKeyCode() == R2D2.keys.getDownKey())
                R2D2.keys.down=false;
        }
    }


    /*  rövid gombnyomások érzékelése a megfelelő
     *  függvények meghívásával
    */
    @Override
    public void keyTyped(KeyEvent e) {

        for (Robot R2D2: gameMapContainer.getRobots()) {

            if(e.getKeyCode()== R2D2.keys.getLeftKey())
                R2D2.turnLeft();
            if(e.getKeyCode() == R2D2.keys.getUpKey())
                R2D2.speedUp();
            if(e.getKeyCode() == R2D2.keys.getRightKey())
                R2D2.turnRight();
            if(e.getKeyCode() == R2D2.keys.getDownKey())
                R2D2.slowDown();
            if(e.getKeyCode() == R2D2.keys.getOilKey())
                R2D2.keys.oil= true;
            if(e.getKeyCode() == R2D2.keys.getGlueKey())
                R2D2.keys.glue= true;
        }}


    /* A csapdára lépés megvalósításáért felelős függvény,
     * a controlMinions() metódus hívja meg.
     */
    public void collision(Robot C3PO){//TODO majd a szkeleton után visszaállítani privátra !!!!
        boolean event = false;
        for (Trap itsATrap: gameMapContainer.getTraps()){

            if (C3PO.getNextPosition().distance(itsATrap.getLocation()) < (C3PO.getHitbox() + itsATrap.getHitbox()))
                {
                    itsATrap.accept(C3PO);
                    event = true;
                }
            else
                C3PO.state = Robot.robotState.NORMAL;
        }
        if(!event) System.out.println("None");
    }

    /*   az irányítás megoldása az aktuális gombváltozók értéke alapján.
     *   Polling módszerrel oldjuk meg.
     */
    private void pollKey(Robot R2D2){

        if(R2D2.keys.left) R2D2.turnLeft();
        if(R2D2.keys.up) R2D2.speedUp();
        if(R2D2.keys.right) R2D2.turnRight();
        if(R2D2.keys.down) R2D2.slowDown();
        if(R2D2.keys.oil) {
            if(R2D2.onGround){
                if (R2D2.ammountofOil <= 0){
                    /* ha nincs olaj nem rakunk le semmit */
                    System.out.println("Kifogytál az olajból!");
                }
                else{
                    /* csökkentjük az oil készletet és létrehozunk a pályán egy új foltot*/
                    System.out.println(""+"    ->[GameControl].amountofOil--"+"");
                    R2D2.ammountofOil--;
                    try {
                        gameMapContainer.addTrap(new Oil(R2D2.getLocation(), 10));
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.toString());
                    }
                }
            }
            /* Miután leraktuk az olajat, ismét false ba állítjuk az olaj gombértéket */
            R2D2.keys.oil= false;
        }
        if(R2D2.keys.glue) {
            if(R2D2.onGround){
                if (R2D2.ammountofGlue <= 0){
                    /* Ha nincs ragacs, nem rakunk le semmit */
                    System.out.println("Kifogytál az ragacsból!");
                }
                else{
                    /*csökkenti az oil készletet, majd létrehozunk a pályán egy új foltot*/
                    System.out.println(""+"    ->[GameControl].amountofGlue--"+"");
                    R2D2.ammountofGlue--;
                    try {
                        gameMapContainer.addTrap(new Glue(R2D2.getLocation(), 10));
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                    }
                }
            }
            /* Miután leraktuk a ragacsot, ismét false ba állítjuk a ragacs gombértéket */
            R2D2.keys.glue= false;
        }
    }

    /*   A robot irányításának "fő" metódusa, melyben sorra meghívjuk
     *   az irányításhoz szükséges korábban definiált metódusokat.
    */

    private void controlMinions(){
        System.out.println(""+"    ->[GameControl].controlMinions()"+"");
        for (Robot R2D2: gameMapContainer.getRobots()){
            //fontos a sorrend
            pollKey(R2D2);
            /*TODO ide kell rajzolás ami fogad egy Pointert ami a következő pozíciója lesz a robotnak*/ R2D2.evaluate();
            R2D2.jump();
            collision(R2D2);
        }
    }

    /* Egy timer, ami fél másodpercenként meghívja a controlMinions -t */

    private void scheduleControlMinions () {
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                controlMinions();
            }

        }, 0, 500);

        //TODO többi időzítését is meg kéne írni
    }
}
