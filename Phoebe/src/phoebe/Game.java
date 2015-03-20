package phoebe;

import phoebe.Control.GameControl;
import phoebe.Model.GameMapContainer;
import phoebe.View.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/* fő osztály, ez indítja magát a játékot,
    itt található a main metódus.
    Tartalmaz egy GameControl objektumot a játék irányításának kezelésére,
    valamint egy GameMapContainer objektumot a pályaelemek tárolására.
 */


public class Game {
        private GameControl gameControl;
        private GameMapContainer gameMapContainer;
        //private GameFrame gameFrame;

        public Game() {
            gameMapContainer = new GameMapContainer(new Dimension(500,500));
            gameControl= new GameControl(gameMapContainer);
           // gameFrame = new GameFrame(gameControl, gameMapContainer);
        }

        //A program belépési pontja

        public static void main(String[] args) {
            // Példányosítás
            Game game = new Game();



            //Robot kirajzolás tesztelése -- András
            Point test = new Point(200,300);
            JFrame gameFrame = new JFrame("Phoebe");

            GameFrame frame = new GameFrame(test, "testrobot");
                gameFrame.setSize(1024, 768);
                frame.setRotation(Math.toRadians(80));

                gameFrame.add(frame);
                frame.repaint();
                gameFrame.setVisible(true);
            System.out.println(frame.getRobotLocation());
                gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //Idáig

            // Új játék indítása
            //game.gameControl.startNewGame();
        }

}
