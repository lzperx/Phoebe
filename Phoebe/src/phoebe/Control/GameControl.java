package phoebe.Control;

import phoebe.Model.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Math;

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

        for (PlayerRobot R2D2: gameMapContainer.getPlayerRobots()) {

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

        for (PlayerRobot R2D2: gameMapContainer.getPlayerRobots()) {

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

        for (PlayerRobot R2D2: gameMapContainer.getPlayerRobots()) {

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
    public void collision(PlayerRobot C3PO){//TODO majd a szkeleton után visszaállítani privátra !!!!
        boolean event = false;

        //Csapdákkal való ütközés lekezelése
        for (Trap itsATrap: gameMapContainer.getTraps()){

            if (C3PO.getNextPosition().distance(itsATrap.getLocation()) < (C3PO.getHitbox() + itsATrap.getHitbox()))
                {
                    itsATrap.accept(C3PO);
                    event = true;
                }
        }

        //kisrobotokkal való ütközés lekezelése
        for (CleanerRobot kemenyenDolgozoKisRobot : gameMapContainer.getCleanerRobots()){
            if(C3PO.getNextPosition().distance(kemenyenDolgozoKisRobot.getLocation()) < (C3PO.getHitbox() + kemenyenDolgozoKisRobot.getHitbox())){
                gameMapContainer.getTraps().add(new Oil(kemenyenDolgozoKisRobot.getLocation()));
                gameMapContainer.getCleanerRobots().remove(kemenyenDolgozoKisRobot);
            }
        }

        //Nagyrobotokkal való ütközés
        for (PlayerRobot R2D2: gameMapContainer.getPlayerRobots()) {
            if (C3PO != R2D2){
                if (C3PO.getNextPosition().distance(R2D2.getLocation()) < (C3PO.getHitbox() + R2D2.getHitbox())) {
                    if (C3PO.getSpeed() > R2D2.getSpeed()) gameMapContainer.getPlayerRobots().remove(R2D2);
                        else gameMapContainer.getPlayerRobots().remove(C3PO);
                }
            }
        }


         if(!event){

            C3PO.state = PlayerRobot.robotState.NORMAL;
            System.out.println("None");
        }

    }



    /* CleanUp metódus a CleanerRobot -ok csapdafelszedésére,
        valamint az új irányuk megadására a következő csapda felé.
     */
    private void CleanUp(CleanerRobot kemenyenDolgozoKisrobot){

            for (Trap itsATrap : gameMapContainer.getTraps()) {
                // ha véletlenül 2 csapda lenne egymáson, csak az egyiket szedi fel egyszerre
                if(kemenyenDolgozoKisrobot.getTimeLeftToClean()<=0) {
                    if (kemenyenDolgozoKisrobot.getNextPosition().distance(itsATrap.getLocation()) < (kemenyenDolgozoKisrobot.getHitbox() + itsATrap.getHitbox())) {
                        // felszedjük a csapdát
                        gameMapContainer.getTraps().remove(itsATrap);
                        //két körig várakozunk
                        kemenyenDolgozoKisrobot.setTimeLeftToClean(2);
                    }
                }
            }
    }

    /*directToNextTrap metódus a Cleanerrobotok irányba állítására
    a legközelebbi csapda felé
     */
    private void directToNextTrap(CleanerRobot kemenyenDolgozoKisrobot){
        // csak akkor számolunk, ha épp nem takarít
        if(kemenyenDolgozoKisrobot.getTimeLeftToClean()<=0){
            // ha ütközés van, random szöget állítunk be az ugrásnak
            if(kemenyenDolgozoKisrobot.isCollision()){
                kemenyenDolgozoKisrobot.setAngle(Math.random()*2*Math.PI);
                kemenyenDolgozoKisrobot.setCollision(false);
            }else{
                // ha van még csapda a pályán, akkor elindul arra, egyébként változatlan irányba ugrál tovább
                if(!gameMapContainer.getTraps().isEmpty()){
                    // a robothoz legközelebbi csapda megkeresésére
                    Trap closestTrap = null;

                    //a robot és a hozzá legközelebbi csapda távolsága,
                    // kezdeti érték jó nagy , hogy biztosan találjon kisebbet
                    double distance = 1000000;

                    // a ciklusban aktuálisan vizsgált csapda és a robot távolsága
                    double currentDistance;
                    for(Trap itsATrap : gameMapContainer.getTraps()){

                        // pitagorasz a robot és a csapdák távolságának kiszámítására a koordinátákból
                /* currentDistance = Math.sqrt(Math.pow(Math.abs(itsATrap.getLocation().getX()-kemenyenDolgozoKisrobot.getLocation().getX()),2)+
                        Math.pow(Math.abs(itsATrap.getLocation().getY()-kemenyenDolgozoKisrobot.getLocation().getY()),2));*/
                        currentDistance = kemenyenDolgozoKisrobot.getLocation().distance(itsATrap.getLocation());


                        if(currentDistance < distance){
                            closestTrap = itsATrap;
                            distance = currentDistance;
                        }
                    }

                    // a továbbhaladás szöge arkusztangenssel számolva (radiánban)
                    double angle;

                    if(closestTrap.getLocation().getX() - kemenyenDolgozoKisrobot.getLocation().getX()>0){
                        angle =  Math.atan(Math.abs(closestTrap.getLocation().getY()-kemenyenDolgozoKisrobot.getLocation().getY())/
                                Math.abs(closestTrap.getLocation().getX() - kemenyenDolgozoKisrobot.getLocation().getX()));
                    } else{     // a negatív tartományban hozzáadunk egy PI t , mivel az atan csak 0-180 fok között képez le, lásd komplex számok
                        angle = Math.PI + Math.atan(Math.abs(closestTrap.getLocation().getY()-kemenyenDolgozoKisrobot.getLocation().getY())/
                                Math.abs(closestTrap.getLocation().getX() - kemenyenDolgozoKisrobot.getLocation().getX()));
                    }

                    kemenyenDolgozoKisrobot.setAngle(angle);
                }
            }
        }
    }


    /*   az irányítás megoldása az aktuális gombváltozók értéke alapján.
     *   Polling módszerrel oldjuk meg.
     */
    private void pollKey(PlayerRobot R2D2){

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
                        gameMapContainer.addTrap(new Oil(R2D2.getLocation()));
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
                        gameMapContainer.addTrap(new Glue(R2D2.getLocation()));
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


    /* kiszárítja a csapdákat, és törli a teljesen szárazakat.
     a controllminions() legvégén kell meghívni.*/
private void removeOldTraps (){
    // végigmegyünk a csapdákon, és szárítunk az olajokon
    for(Trap csapda: gameMapContainer.getTraps()){
        csapda.dry();
        if(csapda.getTimeToLive()<=0){
            gameMapContainer.getTraps().remove(csapda);
        }
    }

}



    /*   A robot irányításának "fő" metódusa, melyben sorra meghívjuk
     *   az irányításhoz szükséges korábban definiált metódusokat.
    */

    private void controlMinions(){
        System.out.println(""+"    ->[GameControl].controlMinions()"+"");
        for (PlayerRobot R2D2: gameMapContainer.getPlayerRobots()){
            //fontos a sorrend
            pollKey(R2D2);
            /*TODO ide kell rajzolás ami fogad egy Pointert ami a következő pozíciója lesz a robotnak*/
            R2D2.evaluate();
            R2D2.jump();
            collision(R2D2);
        }

        // a CleanerRobotok felszedik a csapdákat, ha elég közel értek hozzájuk
        for(CleanerRobot kemenyenDolgozoKisrobot : gameMapContainer.getCleanerRobots()){
            //csökkentjük a hátralévő munkaidőt (lehet negatív is)
            kemenyenDolgozoKisrobot.setTimeLeftToClean(kemenyenDolgozoKisrobot.getTimeLeftToClean()-1);
            //vizsgáljuk hogy van e csapda a robot alatt, ha van, felszedjük
            CleanUp(kemenyenDolgozoKisrobot);
            //vizsgáljuk, hogy két kisrobot ütközött-e
            for(CleanerRobot masikRobot: gameMapContainer.getCleanerRobots()){
                if(kemenyenDolgozoKisrobot!=masikRobot){
                    if(masikRobot.getLocation()==kemenyenDolgozoKisrobot.getLocation()){
                        kemenyenDolgozoKisrobot.setCollision(true);
                    }
                }
            }
            //a következő csapda felé fordul majd elkezd ugrálni a cleanerRobot,
            // ha van következő csapda, és ha nincs épp elfoglalva a takarítással
           if(kemenyenDolgozoKisrobot.getTimeLeftToClean()<=0){
               directToNextTrap(kemenyenDolgozoKisrobot);
               /*TODO ide kell rajzolás ami fogad egy Pointert ami a következő pozíciója lesz a robotnak*/
               kemenyenDolgozoKisrobot.evaluate();
               kemenyenDolgozoKisrobot.jump();
           }

        }


        //removeOldtraps a végére mindig, eltűntetjük a kiszáradt csapdákat
        removeOldTraps();
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
