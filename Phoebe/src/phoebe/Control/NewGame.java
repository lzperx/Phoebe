package phoebe.Control;

import phoebe.Model.GameMapContainer;

import java.awt.*;

/**
 * Created by andri_000 on 2015.03.07..
 */


/* Az új játék felépítéséért felelős objektum.
   Az inicializálás is itt történik meg.
 */
public class NewGame {
    private int width = 800;
    private int height = 600;

   public void initialize(){

   }

    // a játék felépítése
    public void startGame(){
        GameMapContainer gameMap = new GameMapContainer(new Dimension(width,height));
        GameControl controller = new GameControl(gameMap);
    }

}
