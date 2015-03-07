package phoebe.Model;

import java.awt.*;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot extends GameElements implements VehicleProp {

    // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    public static enum robotState {
        NORMAL,OILED
    }

    //átadjuk az adott pályát is, hogy tudjon lerakni trappeket.
    private GameMapContainer gameMapContainer;

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

    //igaz, ha éppen az adott gomb van lenyomva



    //robot talajhoz viszonyított állapota
    public robotState state = robotState.NORMAL;

    public Robot(Point location,int hitbox,KeyMap keys,GameMapContainer gameMapContainer) {
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
        this.gameMapContainer=gameMapContainer;
    }


    public Point evaluate (){
        nextPosition = new Point(
                (int)(speed*Math.cos(angle)),
                (int)(speed*Math.sin(angle))
        );
        return nextPosition;
    }



    //setterek az Interfacehez a Visitor pattern miatt

    @Override
    public void setState(robotState newState){
        state = newState;
    }

    @Override
    public void setSpeed (int newSpeed) {speed = newSpeed;}


    //getter fv-ek


    public Point getNextPosition() {
        return nextPosition;
    }


    public double getAngle() {
        return angle;
    }


    //sebességet és elhajlást módosító fv-ek  (setterek)

    public void Jump(){
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


    public void addDistance(double moreDistance){
        distance += moreDistance;
    }


    @Override
    public robotState getState() {
        return state;
    }

    @Override
    public int getSpeed(){ return speed;}


}
