package phoebe.Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

    }

}
