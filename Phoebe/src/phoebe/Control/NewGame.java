package phoebe.Control;

import phoebe.Model.GameMapContainer;

/**
 * Created by andri_000 on 2015.03.07..
 */

public class NewGame {
    private int width = 800;
    private int height = 600;


   public void initialize(){

   }

    public void startGame(){
        GameMapContainer gameMap = new GameMapContainer(width,height);
        GameControl controller = new GameControl(gameMap);
    }

}
