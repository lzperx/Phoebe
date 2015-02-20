package phoebe.Control;

import phoebe.Model.GameObjects;
import phoebe.Model.Robot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Struct;

/**
 * Created by Muresan73 on 15. 02. 20..
 */

//Ez vezérli az egész game-et
public class GameControl implements KeyListener {


    //aki tud szebb megoldást azt szívesen fogadom :)
    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;
    GameObjects GameO;

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37: left = true;
                     break;
            case 38: up = true;
                     break;
            case 39: right = true;
                     break;
            case 40: down = true;
                     break;
            default: break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37: left = false;
                break;
            case 38: up = false;
                break;
            case 39: right = false;
                break;
            case 40: down = false;
                break;
            default: break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    private void controlMinions(){
        for (Robot R2D2: GameO.getRobots()){
            if(left) R2D2.turnLeft();
            if(up) R2D2.speedUp();
            if(right) R2D2.turnRight();
            if(down) R2D2.slowDown();
        }

    }

}
