package phoebe.Model;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot {

    public enum robotState {
        JUMP,ONGROUND      // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    }


    //helyzet
    private int x;
    private int y;
    private int speed = 0;
    //megtett távolság
    private int distance = 0;
    robotState state = robotState.JUMP;

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
        if (state == robotState.ONGROUND) {
            speed /= 2;
        }
    }

    public void turnLeft(){
        if (state == robotState.ONGROUND) {

        }
    }

    public void turnRight(){
        if (state == robotState.ONGROUND) {

        }
    }

    public void speedUp(){
        if (state == robotState.ONGROUND) {

        }
    }

    public void slowDown(){
       if (state == robotState.ONGROUND) {

        }
    }
}
