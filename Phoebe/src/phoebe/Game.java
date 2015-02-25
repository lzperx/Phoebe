package phoebe;

import phoebe.Control.GameControl;
import phoebe.Model.GameMapContainer;

public class Game {
        private GameControl gameControl;
        private GameMapContainer gameMapContainer;
        //private GameFrame gameFrame;


        public Game() {
            gameMapContainer = new GameMapContainer(500,500);
            gameControl= new GameControl(gameMapContainer);
           // gameFrame = new GameFrame(gameControl, gameMapContainer);
        }

        //A program belépési pontja

        public static void main(String[] args) {
            // Példányosítás
            Game game = new Game();


            // Új játék indítása
            //game.gameControl.startNewGame();
        }

}
