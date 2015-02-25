package phoebe.Control;

import phoebe.Model.GameMapContainer;
import phoebe.Model.Robot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Muresan73 on 15. 02. 20..
 */

//Ez vezérli az egész game-et
public class GameControl implements KeyListener {


    private GameMapContainer gameMapContainer;

    public GameControl(GameMapContainer gameMapContainer) {
        this.gameMapContainer = gameMapContainer;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        for (Robot R2D2: gameMapContainer.getRobots()) {

            if(e.getKeyCode()== R2D2.getLeftKey())
                R2D2.left=true;
            if(e.getKeyCode() == R2D2.getUpKey())
                R2D2.up=true;
            if(e.getKeyCode() == R2D2.getRightKey())
                R2D2.right=true;
            if(e.getKeyCode() == R2D2.getDownKey())
                R2D2.down=true;
            if(e.getKeyCode() == R2D2.getOilKey())
                R2D2.oil= true;
            if(e.getKeyCode() == R2D2.getGlueKey())
                R2D2.glue= true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        for (Robot R2D2: gameMapContainer.getRobots()) {

            if(e.getKeyCode()== R2D2.getLeftKey())
                R2D2.left=false;
            if(e.getKeyCode() == R2D2.getUpKey())
                R2D2.up=false;
            if(e.getKeyCode() == R2D2.getRightKey())
                R2D2.right=false;
            if(e.getKeyCode() == R2D2.getDownKey())
                R2D2.down=false;
            if(e.getKeyCode() == R2D2.getOilKey())
                R2D2.oil= false;
            if(e.getKeyCode() == R2D2.getGlueKey())
                R2D2.glue= false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    //a robot irányítása: itt állítjuk be, hogy ha jobbra nyomtunk, akkor a turnRight() fusson le

    private void controlMinions(){
        for (Robot R2D2: gameMapContainer.getRobots()){
            R2D2.evaluate();

//TODO vezérlés

        }

    }

}
