package phoebe.Model;

import java.awt.*;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot extends GameElements {

    // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    public static enum robotState {
        NORMAL,OILED
    }

    //A robot ahova ugrani fog legközelebb
    private Point nextPosition;

    // a robot sebessége
    public int speed = 0;

    //szögelfordulás
    private double angle = 0;

    //összesen megtett távolság
    private double distance = 0;

    //Levegőben van
    public boolean onGround = true;

    //Összes oil
    public int ammountofOil;
    //Összes glue
    public int ammountofGlue;


   public KeyMap keys;


    //robot talajhoz viszonyított állapota
    public robotState state = robotState.NORMAL;

    public Robot(Point location,int hitbox,KeyMap keys) {
        super(location,hitbox);

        ammountofGlue = 3;
        ammountofOil = 3;
        this.keys = new KeyMap(
                keys.getLeftKey(),
                keys.getUpKey(),
                keys.getRightKey(),
                keys.getDownKey(),
                keys.getOilKey(),
                keys.getGlueKey());
    }


    public Point evaluate (){
        nextPosition = new Point(
                (int)(speed*Math.cos(angle))+(int)location.getX(),
                (int)(speed*Math.sin(angle))+(int)location.getY()
        );
        return nextPosition;
    }



    //setterek az Interfacehez a Visitor pattern miatt


    public void setState(robotState newState){
        state = newState;
    }


    public void setSpeed (int newSpeed) {speed = newSpeed;}


    //getter fv-ek


    public Point getNextPosition() {
        return nextPosition;
    }


    public double getAngle() {
        return angle;
    }


    //sebességet és elhajlást módosító fv-ek  (setterek)

    public void jump(){
        distance += nextPosition.distance(location);
        location = nextPosition;
    }


    public void turnLeft(){
        if (state == robotState.NORMAL)
        {
          // szögelfordulás balra 10 fokkal (minden nextPosition beállításkor az angle=0 lesz)
            angle =- 0.1;//TODO normális érték
        }
    }

    public void turnRight(){
        if (state == robotState.NORMAL)
        {
            // szögelfordulás jobbra 10 fokkal (minden nextPosition beállításkor az angle=0 lesz)
            angle =+ 0.1;//TODO normális érték
        }
    }

    public void speedUp(){

        if (state == robotState.NORMAL)
        {
            speed += 15;
        }
    }

    public void slowDown(){
        if (state == robotState.NORMAL)
        {
            speed += 15;
        }
    }


    public double getDistance(){return distance;}


    public robotState getState() {
        return state;
    }


    public int getSpeed(){ return speed;}


    /*****************************************************************************************************************/
    /*****                                         VISITOR PATTERN                                               *****/
    /*****************************************************************************************************************/


    void visit(Oil oil){
        state = robotState.OILED;
    }

    void visit(Glue glue){
       speed /= 2;
    }




}
