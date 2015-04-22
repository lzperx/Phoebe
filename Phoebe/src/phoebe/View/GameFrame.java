

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Geri on 2015.02.24..
 */

public class GameFrame extends JComponent {

    Dimension robotSize = null;
    Point robot = null;
    double rotation = 0;
    BufferedImage testRobot = null;

    /*Beállítja a GameFrame-t,
      hogy a kívánt nevű robottal lehessen játszani.
     */
    public GameFrame(Point robot1Location, String name){
        robot = robot1Location;
        testRobot = loadRobot(name);
        robotSize = new Dimension(testRobot.getWidth(),testRobot.getHeight());
    }

    /* Betölti a robot képét a program futási mappájában lévő robot mappából.
       A robot képét .png kiterjesztésben kell a robot mappában tárolni.
       A betöltendő robot nevét paraméterként kell átadni a metódusnak
       (ez a file neve)
    */
    private BufferedImage loadRobot(String name){

        try{
            testRobot = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "robot" + File.separator + name + ".png"));
        }catch (Exception e){
            System.out.println("File not found");
            System.out.println(System.getProperty("user.dir") + File.separator + "robot" + File.separator);
        }
        return testRobot;
    }

    // getterek
    public Point getRobotLocation(){
        return robot;
    }

    public Dimension getRobotSize(){
        return robotSize;
    }

    // setterek
    public void setRotation(double angle){
        rotation = angle;
    }

    public void  setRobotLocation(Point newLocation){
        robot = newLocation;
    }

    // a megfelelő irányba fordított robot kirajzolása
    public void paintComponent(Graphics g){
        AffineTransform transform = new AffineTransform();
        transform.rotate(rotation, testRobot.getWidth()/2, testRobot.getHeight()/2);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        testRobot = op.filter(testRobot, null);
        g.drawImage(testRobot,(int)robot.getX()/2,(int)robot.getY()/2,null);
    }
}