package phoebe;

import phoebe.Control.NewGame;
import phoebe.Model.*;
import phoebe.Model.Robot;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* fő osztály, ez indítja magát a játékot,
    itt található a main metódus.
 */


public class Main {

        //A program belépési pontja

        public static void main(String[] args) {
           NewGame game = new NewGame();
            boolean valid = true;
            Robot actualRobot;
            int value;
            int time=200;


            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String startcommand = new String("dummy");
                while (!startcommand.equals("startgame")) {startcommand = in.readLine();}
                game.initialize(new Dimension(500, 500));
                System.out.println("Game Started :)");

                while (time > 0) {

                    //TODO ha kifut a robot a pályáról break


                    System.out.println("**********************************************");


                    System.out.println("Robot1: [x="+game.gameMap.getRobots().get(0).getLocation().getX()+
                            ", y="+game.gameMap.getRobots().get(0).getLocation().getY()+
                            ", v="+game.gameMap.getRobots().get(0).getSpeed()+"]");
                    System.out.println("Robot2: [x="+game.gameMap.getRobots().get(0).getLocation().getX()+
                            ", y="+game.gameMap.getRobots().get(0).getLocation().getY()+
                            ", v="+game.gameMap.getRobots().get(0).getSpeed()+"]");

                    System.out.println("Robot1 events: ");
                    game.controller.collision(game.gameMap.getRobots().get(0));
                    System.out.println("Robot2 events: ");
                    game.controller.collision(game.gameMap.getRobots().get(1));

                    System.out.println("[Time: "+ time +" s remain]");
                    System.out.println("=========================");

                    for (int i = 0; i <2; i++) {
                        actualRobot = game.gameMap.getRobots().get(i);
                        while (!valid) {
                            System.out.print("Robot" + i + ":\\> ");
                            String[] cmdLine = in.readLine().split(" ");

                            switch (cmdLine[0]) {
                                //TODO: együtt nem lehetne a start/exit + a többi parancs

                                case "exitgame":
                                    in.close();
                                    System.exit(0);
                                    break;

                                case "speedup":
                                    try {
                                        value = Integer.parseInt(cmdLine[1]);
                                        if (value > 0 && value < 20) actualRobot.setAcceleration(value);

                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid Value!");
                                        valid = false;
                                    }
                                    break;
                                case "slowdown":
                                    try {
                                        value = Integer.parseInt(cmdLine[1]);
                                        if (value > 0 && value < 20) {
                                            actualRobot.setAcceleration(value);
                                            valid = true;
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid Value!");
                                        valid = false;
                                    }
                                    break;
                                case "right":
                                    try {
                                        value = Integer.parseInt(cmdLine[1]);
                                        if (value > 0 && value < 90) {
                                            actualRobot.setRightTurnDegree(value);
                                            valid = true;
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid Value!");
                                        valid = false;
                                    }

                                    break;
                                case "left":
                                    try {
                                        value = Integer.parseInt(cmdLine[1]);
                                        if (value > 0 && value < 90) {
                                            actualRobot.setLeftTurnDegree(value);
                                            valid = true;
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid Value!");
                                        valid = false;
                                    }

                                    break;
                                case "putglue":
                                    if (actualRobot.ammountofGlue <= 0){
                    /* Ha nincs ragacs, nem rakunk le semmit */
                                        System.out.println("You are Out of Glue!");
                                        valid = false;
                                    }
                                    else{
                    /*csökkenti az oil készletet, majd létrehozunk a pályán egy új foltot*/
                                        actualRobot.ammountofGlue--;
                                        game.gameMap.addTrap(new Glue(actualRobot.getLocation(), 10));
                                        valid = true;
                                    }

                                    break;
                                case "putoil":
                                    if (actualRobot.ammountofOil <= 0){
                    /* Ha nincs ragacs, nem rakunk le semmit */
                                        System.out.println("You are Out of Oil!");
                                        valid = false;
                                    }
                                    else{
                    /*csökkenti az oil készletet, majd létrehozunk a pályán egy új foltot*/
                                        actualRobot.ammountofGlue--;
                                        game.gameMap.addTrap(new Glue(actualRobot.getLocation(), 10));
                                        valid = true;
                                    }

                                    break;
                                default:
                                    System.out.println(cmdLine[0] + ": command not found"); //A rendes terminál is így irja ki :)
                                    valid = false;
                            }
                        }
                    }


                    game.gameMap.getRobots().get(0).evaluate();
                    game.gameMap.getRobots().get(1).evaluate();

                    game.gameMap.getRobots().get(0).jump();
                    game.gameMap.getRobots().get(1).jump();
                    time -= 5;
                    System.out.println("**********************************************");
                    System.out.println();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
    if(time < 0) {
        if (game.gameMap.getRobots().get(0).getDistance() > game.gameMap.getRobots().get(1).getDistance())
            System.out.println("Robot1 Győzött");
        else System.out.println("Robot2 Győzött");
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
