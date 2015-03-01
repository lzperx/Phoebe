package phoebe.Control;

import phoebe.Model.GameMapContainer;
import phoebe.Model.Robot;
import phoebe.Model.Trap;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Muresan73 on 15. 02. 20..
 */

//Ez vezérli az egész game-et
public class GameControl implements KeyListener {


    private GameMapContainer gameMapContainer;

    public GameControl(GameMapContainer gameMapContainer) {
        this.gameMapContainer = gameMapContainer;
    }

    private final Timer timer =new Timer();


    @Override
    public void keyPressed(KeyEvent e) {

        for (Robot R2D2: gameMapContainer.getRobots()) {

            if(e.getKeyCode()== R2D2.keys.getLeftKey())
                R2D2.left=true;
            if(e.getKeyCode() == R2D2.keys.getUpKey())
                R2D2.up=true;
            if(e.getKeyCode() == R2D2.keys.getRightKey())
                R2D2.right=true;
            if(e.getKeyCode() == R2D2.keys.getDownKey())
                R2D2.down=true;
            if(e.getKeyCode() == R2D2.keys.getOilKey())
                R2D2.oil= true;
            if(e.getKeyCode() == R2D2.keys.getGlueKey())
                R2D2.glue= true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        for (Robot R2D2: gameMapContainer.getRobots()) {

            if(e.getKeyCode()== R2D2.keys.getLeftKey())
                R2D2.left=false;
            if(e.getKeyCode() == R2D2.keys.getUpKey())
                R2D2.up=false;
            if(e.getKeyCode() == R2D2.keys.getRightKey())
                R2D2.right=false;
            if(e.getKeyCode() == R2D2.keys.getDownKey())
                R2D2.down=false;
            if(e.getKeyCode() == R2D2.keys.getOilKey())
                R2D2.oil= false;
            if(e.getKeyCode() == R2D2.keys.getGlueKey())
                R2D2.glue= false;
        }
    }

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
                R2D2.putOil();
            if(e.getKeyCode() == R2D2.keys.getGlueKey())
                R2D2.putGlue();
    }}

    public void collision(Robot C3PO){
        for (Trap i: gameMapContainer.getTraps()){
            if (C3PO.getLocation().distance(i.getLocation()) < (C3PO.getHitbox() + i.getHitbox())) C3PO.itsATrap(i);
        }
    }

    //a robot irányítása: itt állítjuk be, hogy ha jobbra nyomtunk, akkor a turnRight() fusson le

     void controlMinions(){
        for (Robot R2D2: gameMapContainer.getRobots()){
            collision(R2D2);  //fontos a sorrend
            R2D2.pollKey();
            /*TODO ide kell rajzolás ami fogad egy Pointert ami a következő pozíciója lesz a robotnak*/ R2D2.evaluate();
            R2D2.Jump();

        }
    }

    // fél másodpercenként meghívja a controlMinions -t

    void scheduleControlMinions () {
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                controlMinions();
            }

        }, 0, 500);
    }
}
