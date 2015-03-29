package phoebe;

import phoebe.Control.NewGame;
import phoebe.Model.*;
import phoebe.Model.PlayerRobot;

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

            while (true) {
            NewGame game = new NewGame();
            boolean valid = true;
            PlayerRobot actualPlayerRobot;
            int value;
            int time=200;


                try {

                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    String startcommand = new String("dummy");
                    System.out.println("\nEnter the command (startgame | exitgame):");
                    while (!startcommand.equals("startgame")) {
                        startcommand = in.readLine();
                        if(startcommand.equals("exitgame")){
                            in.close();
                            System.out.println("Game Over");
                            System.exit(0);
                        }
                    }
                    game.initialize(new Dimension(500, 500));
                    System.out.println("*****************Game started!****************");

                    game.gameMap.getPlayerRobots().get(0).evaluate();
                    game.gameMap.getPlayerRobots().get(1).evaluate();


                    leesettarobot:
                    while (time >= 0) {

                        // ha kifut a robot a pályáról break
                        if (game.gameMap.getPlayerRobots().get(0).getLocation().getY() >= game.dimension.height ||
                                game.gameMap.getPlayerRobots().get(0).getLocation().getY() <= 0 ||
                                game.gameMap.getPlayerRobots().get(0).getLocation().getX() >= game.dimension.width ||
                                game.gameMap.getPlayerRobots().get(0).getLocation().getX() <= 0) {
                            System.out.println("Robot1 fell off ");
                            System.out.println("Game Over");
                            System.out.println("Robot2 won!");

                            break;
                        }
                        if (game.gameMap.getPlayerRobots().get(1).getLocation().getY() >= game.dimension.height ||
                                game.gameMap.getPlayerRobots().get(1).getLocation().getY() <= 0 ||
                                game.gameMap.getPlayerRobots().get(1).getLocation().getX() >= game.dimension.width ||
                                game.gameMap.getPlayerRobots().get(1).getLocation().getX() <= 0) {
                            System.out.println("Robot2 fel off ");
                            System.out.println("Game Over");
                            System.out.println("Robot1 won!");

                            break;
                        }

                        System.out.println("**********************************************");

                        System.out.println("Robot1: [x=" + game.gameMap.getPlayerRobots().get(0).getLocation().getX() +
                                ", y=" + game.gameMap.getPlayerRobots().get(0).getLocation().getY() +
                                ", v=" + game.gameMap.getPlayerRobots().get(0).getSpeed() + "]");
                        System.out.println("Robot2: [x=" + game.gameMap.getPlayerRobots().get(1).getLocation().getX() +
                                ", y=" + game.gameMap.getPlayerRobots().get(1).getLocation().getY() +
                                ", v=" + game.gameMap.getPlayerRobots().get(1).getSpeed() + "]");

                        System.out.print("Robot1 events: \n");
                        game.controller.collision(game.gameMap.getPlayerRobots().get(0));
                        System.out.print("Robot2 events: \n");
                        game.controller.collision(game.gameMap.getPlayerRobots().get(1));

                        System.out.println("[Time: " + time + " s remain]");
                        System.out.println("=========================");

                        System.out.println(""+"    ->[GameControl].controlMinions()"+"");
                        for (int i = 0; i < 2; i++) {

                            actualPlayerRobot = game.gameMap.getPlayerRobots().get(i);

                            do {
                                System.out.print("Robot" + (i + 1) + ":\\> ");
                                String[] cmdLine = in.readLine().split(" ");

                                switch (cmdLine[0]) {

                                    case "exitgame":
                                        in.close();
                                        System.exit(0);
                                        break;

                                    case "speed":
                                        try {
                                            value = Integer.parseInt(cmdLine[1]);
                                            if (value >= -20 && value <= 20) {
                                                actualPlayerRobot.setAcceleration(value);
                                                valid = true;
                                            } else {
                                                System.out.println(" " + "Invalid Value!" + "");
                                                valid = false;
                                            }

                                        } catch (Exception e) {
                                            System.out.println(" " + "Invalid Value!" + "");
                                            valid = false;
                                        }
                                        break;

                                    case "right":
                                        try {
                                            value = Integer.parseInt(cmdLine[1]);
                                            if (value >= 0 && value <= 90) {
                                                actualPlayerRobot.setRightTurnDegree(value);
                                                valid = true;
                                            } else {
                                                System.out.println(" " + "Invalid Value!" + "");
                                                valid = false;
                                            }

                                        } catch (Exception e) {
                                            System.out.println(" " + "Invalid Value!" + "");
                                            valid = false;
                                        }

                                        break;
                                    case "left":
                                        try {
                                            value = Integer.parseInt(cmdLine[1]);
                                            if (value >= 0 && value <= 90) {
                                                actualPlayerRobot.setLeftTurnDegree(value);
                                                valid = true;
                                            } else {
                                                System.out.println(" " + "Invalid Value!" + "");
                                                valid = false;
                                            }

                                        } catch (Exception e) {
                                            System.out.println(" " + "Invalid Value!" + "");
                                            valid = false;
                                        }

                                        break;
                                    case "putglue":
                                        if (actualPlayerRobot.ammountofGlue <= 0) {
                    /* Ha nincs ragacs, nem rakunk le semmit */
                                            System.out.println("You are Out of Glue!");
                                            valid = false;
                                        } else {
                    /*csökkenti az oil készletet, majd létrehozunk a pályán egy új foltot*/
                                            System.out.println(""+"    ->[GameControl].amountofGlue--"+"");
                                            actualPlayerRobot.ammountofGlue--;
                                            game.gameMap.addTrap(new Glue(actualPlayerRobot.getLocation()));
                                            valid = true;
                                        }

                                        break;
                                    case "putoil":
                                        if (actualPlayerRobot.ammountofOil <= 0) {
                    /* Ha nincs ragacs, nem rakunk le semmit */
                                            System.out.println("You are Out of Oil!");
                                            valid = false;
                                        } else {
                    /*csökkenti az oil készletet, majd létrehozunk a pályán egy új foltot*/
                                            System.out.println(""+"    ->[GameControl].amountofOil--"+"");
                                            actualPlayerRobot.ammountofOil--;
                                            try{game.gameMap.addTrap(new Oil(actualPlayerRobot.getLocation()));
                                            valid = true;}
                                            catch (Exception e){
                                                System.out.println("The field is full");
                                            }
                                        }

                                        break;
                                    default:
                                        System.out.println(cmdLine[0] + "" + " : Command not found" + ""); //A rendes terminál is így irja ki :)
                                        valid = false;
                                }
                            } while (!valid);
                        }


                        game.gameMap.getPlayerRobots().get(0).evaluate();
                        game.gameMap.getPlayerRobots().get(1).evaluate();

                        game.gameMap.getPlayerRobots().get(0).jump();
                        game.gameMap.getPlayerRobots().get(1).jump();
                        time -= 5;
                        System.out.println("**********************************************");
                        System.out.println();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (time <= 0) {
                    System.out.println("Game Over");

                    if (game.gameMap.getPlayerRobots().get(0).getDistance() > game.gameMap.getPlayerRobots().get(1).getDistance())
                        System.out.println("Robot1 won!");
                    else System.out.println("Robot2 won!");
                }

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
