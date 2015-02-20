package phoebe.Model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static phoebe.Model.Robot.robotState.ONGROUND;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot {

    public static enum robotState {
        JUMP,ONGROUND      // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    }


    //helyzet
    private int x;
    private int y;
    private int speed = 0;
    //megtett távolság
    private int distance = 0;
    robotState state = ONGROUND;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public void getGlued() {
        if (state == ONGROUND) {
            speed /= 2;
        }
    }

    public void turnLeft(){
        if (state == ONGROUND) {
                            // TO DO
        }
    }

    public void turnRight(){
        if (state == ONGROUND) {
                            // TO DO
        }
    }

    public void speedUp(){

        if (state == ONGROUND) {
                            // TO DO
        }
    }

    public void slowDown(){
       if (state == ONGROUND) {
                            // TO DO
        }
    }
}
