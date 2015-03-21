package phoebe;

import phoebe.Control.NewGame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* fő osztály, ez indítja magát a játékot,
    itt található a main metódus.
 */


public class Main {

        //A program belépési pontja

        public static void main(String[] args) {
           NewGame game = new NewGame();

            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    String[] cmdLine = in.readLine().split(" ");

                    switch (cmdLine[0]) {
                        //TODO: együtt nem lehetne a start/exit + a többi parancs

                        case "exitgame":
                            in.close();
                            System.exit(0);
                            break;
                        case "startgame":
                            game.initialize(new Dimension(500,500));
                            game.startGame();
                            break;
                        case "speedup":
                            //todo kérdés: ha függvényeink a robotban nem várnak konkrét számot (pl speedup 12),
                            //todo         így át kéne ideiglenesen írni ezeket a fv-eket vagy csak speedup lenne szám nélkül

                            break;
                        case "slowdown":

                            break;
                        case "right":

                            break;
                        case "left":

                            break;
                        case "putglue":

                            break;
                        case "putoil":

                            break;
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


    /*
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

    */
        }

}
