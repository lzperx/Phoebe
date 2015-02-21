package phoebe;

import phoebe.Control.GameControl;
import phoebe.Model.GameObjectsModel;

public class Game {
        private GameControl gameControl;
        private GameObjectsModel gameObjectsModel;
        //private GameFrame gameFrame;


        public Game() {
            gameObjectsModel = new GameObjectsModel(500,500);
            gameControl= new GameControl(gameObjectsModel);
           // gameFrame = new GameFrame(gameControl, gameObjectsModel);
        }

        //A program belépési pontja

        public static void main(String[] args) {
            // Példányosítás
            Game game = new Game();


            // Új játék indítása
            //game.gameControl.startNewGame();
        }

}
