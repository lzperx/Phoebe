package phoebe.Control;

import phoebe.Model.GameObjectsModel;
import phoebe.Model.Robot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Muresan73 on 15. 02. 20..
 */

//Ez vezérli az egész game-et
public class GameControl implements KeyListener {


    private GameObjectsModel gameObjectsModel;

    public GameControl(GameObjectsModel gameObjectsModel) {
        this.gameObjectsModel = gameObjectsModel;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        for (Robot R2D2: gameObjectsModel.getRobots()) {

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

        for (Robot R2D2: gameObjectsModel.getRobots()) {

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
        for (Robot R2D2: gameObjectsModel.getRobots()){
            if(R2D2.left) R2D2.turnLeft();
            if(R2D2.up) R2D2.speedUp();
            if(R2D2.right) R2D2.turnRight();
            if(R2D2.down) R2D2.slowDown();
            if(R2D2.oil) R2D2.putOil();
            if(R2D2.glue)R2D2.putGlue();
        }

    }

}
