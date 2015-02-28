package phoebe.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Geri on 2015.02.24..
 */
public class GameFrame extends JComponent {


    Dimension robotSize = null;
    Point robot1 = null;
    Point robot2 = null;

    BufferedImage testRobot = null;

    public GameFrame(Point robot1Location, String name){
        robot1 = robot1Location;
        testRobot = loadRobot(name);
        robotSize = new Dimension(testRobot.getWidth(),testRobot.getHeight());
    }

    private BufferedImage loadRobot(String name){

        try{
            testRobot = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "robot" + File.separator + name + ".png"));
        }catch (Exception e){
            System.out.println("File not found");
            System.out.println(System.getProperty("user.dir") + File.separator + "robot" + File.separator);
        }
        return testRobot;
    }

    public Dimension getRobotSize(){
        return robotSize;
    }

    public void paintComponent(Graphics g){

        g.drawImage(testRobot,100,300,null);

    }

}

