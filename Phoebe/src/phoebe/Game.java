package phoebe;

import phoebe.Control.GameControl;
import phoebe.Model.GameObjects;
import phoebe.Model.Keyboard;
import phoebe.Model.Robot;

public class Game {
        private GameControl gameControl;
        private GameObjects gameObjects;
        //private GameFrame gameFrame;


        public Game() {
            gameObjects = new GameObjects(500,500);
            gameControl= new GameControl(gameObjects);
           // gameFrame = new GameFrame(gameControl, gameObjects);
        }

        //A program belépési pontja

        public static void main(String[] args) {
            // Példányosítás
            Game game = new Game();

            //Példányrobot kipróbálása (nyilakkal)
            game.gameObjects.addRobot(new Robot(10,10,new Keyboard(37,38,39,40)));

            // Új játék indítása
            //game.gameControl.startNewGame();
        }
}
