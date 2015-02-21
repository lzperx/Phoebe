package phoebe;

import phoebe.Control.GameControl;
import phoebe.Model.GameObjectsModel;
        

public class Game {
        private GameControl gameControl;
        private GameObjectsModel gameObjectsModel;
        //private GameFrame gameFrame;


        public Game() {
            gameObjectsModel = new GameObjectsModel(500,500);
            gameControl = new GameControl(gameObjectsModel);
           // gameFrame = new GameFrame(gameControl, gameObjectsModel);
        }

        //A program belĂ©pĂ©si pontja

        public static void main(String[] args) {
            // PĂ©ldĂˇnyosĂ­tĂˇs
            Game game = new Game();


            // Ăšj jĂˇtĂ©k indĂ­tĂˇsa
            //game.gameControl.startNewGame();
        }

}
