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
            if(e.getKeyCode() == R2D2.keys.getOilKey())
                R2D2.keys.oil= false;
            if(e.getKeyCode() == R2D2.keys.getGlueKey())
                R2D2.keys.glue= false;
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
            double tempDistance = C3PO.getNextPosition().distance(i.getLocation());
            if (tempDistance < (C3PO.getHitbox() + i.getHitbox())) C3PO.itsATrap(i);
            else C3PO.state = Robot.robotState.NORMAL;
            C3PO.addDistance(tempDistance);
        }
    }

    //a robot irányítása: itt állítjuk be, hogy ha jobbra nyomtunk, akkor a turnRight() fusson le

     void controlMinions(){
        for (Robot R2D2: gameMapContainer.getRobots()){
              //fontos a sorrend
            R2D2.pollKey();
            /*TODO ide kell rajzolás ami fogad egy Pointert ami a következő pozíciója lesz a robotnak*/ R2D2.evaluate();
            R2D2.Jump();
            collision(R2D2);
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
