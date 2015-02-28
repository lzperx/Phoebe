package phoebe;

import phoebe.Control.GameControl;
import phoebe.Model.GameMapContainer;
import phoebe.View.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

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



            //Robot kirajzolás tesztelése -- András
            Point test = new Point(300,200);
            JFrame gameFrame = new JFrame("Phoebe");

            GameFrame frame = new GameFrame(test, "testrobot");

                frame.setRotation(Math.toRadians(90));
                gameFrame.add(frame);
                frame.repaint();
                gameFrame.setSize(800, 600);
                gameFrame.setVisible(true);
                gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //Idáig

            // Új játék indítása
            //game.gameControl.startNewGame();
        }

}
