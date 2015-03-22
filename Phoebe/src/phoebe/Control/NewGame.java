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

   private Dimension dimension;

   //=============================================================
   //-----------Ideiglenes csak szkeletonos változók--------------
   //=============================================================
    GameMapContainer gameMap;

   //=============================================================

   public void initialize(Dimension dimension){
        this.dimension=dimension;
   }

    //Játék kezdése
    public void startGame(){

         gameMap = new GameMapContainer(dimension);//TODO fel kell tölteni a game MAp ot elemekkel !!!!
        GameControl controller = new GameControl(gameMap);

    }

}
