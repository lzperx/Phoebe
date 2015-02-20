package phoebe;

import phoebe.Control.GameControl;
import phoebe.Model.GameObjects;

public class Game {
        private GameControl gameControl;
        private GameObjects gameObjects;
        private GameFrame gameFrame;

        /**
         * A konstruktorban létrehozzuk a tagváltozókat
         */
        public Game() {
            gameObjects = new GameObjects(500,500);
            gameControl= new GameControl(gameObjects);
            gameFrame = new GameFrame(gameControl, gameObjects);
        }

        //A program belépési pontja

        public static void main(String[] args) {
            // Példányosítás
            Game game = new Game();
            // Új játék indítása
            game.gameControl.startNewGame();
        }
}
