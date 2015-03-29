package phoebe.Model;

import java.awt.*;

/**
 * Created by Brumi on 3/29/2015.
 */
public class CleanerRobot extends GameElements{

    //A robot ahova ugrani fog legközelebb
    protected Point nextPosition;

    // a robot kezdő sebessége
    public int speed = 20; //TODO értelmes érték beállítása


    // mutatja, hogy van e épp ütközés másik robottal, ha igen, irányváltás
    private boolean collision =false;


    //szög
    protected double angle = 0;

    //Levegőben van
    public boolean onGround = true;

    // mennyi ideig inaktív még a kisrobot, amíg takarít, ha 0, vagy negatív érték, akkor ugrál
    private int timeLeftToClean =0;



    // az ugrás utáni következő pozíció kiszámítása
    public Point evaluate (){
        System.out.println(""+"    ->[Robot].evaluate()"+"" );
        nextPosition = new Point(
                (int)(speed*Math.cos(angle))+(int)location.getX(),
                (int)(speed*Math.sin(angle))+(int)location.getY()
        );
        System.out.println(""+"    <-[Robot].evaluate().return(nextPosition)"+"" );
        return nextPosition;
    }

    //getter fv-ek

    public boolean isCollision() {
        return collision;
    }

    public int getTimeLeftToClean() {
        return timeLeftToClean;
    }

    public Point getNextPosition() {
        return nextPosition;
    }

    public double getAngle() {
        return angle;
    }


    // setter fv - ek

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setTimeLeftToClean(int timeLeftToClean) {
        this.timeLeftToClean = timeLeftToClean;
    }

    //sebességet és elhajlást módosító fv-ek  (setterek)
    public void jump(){
        System.out.println(""+"    ->[Robot].jump()"+"" );
        location = nextPosition;
    }


    public CleanerRobot(Point location, int hitbox) {
        super(location, hitbox);
    }
}
