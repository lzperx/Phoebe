package phoebe.Model;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot extends GameElements {

    // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    private static enum robotState {
        JUMP,ONGROUND
    }



    // minden körben ennyit adunk az X-hez
    private int speed = 0;

    //minden lépésnél ennyit adunk az Y-hoz
    //ez az elhajlás
    private int deflection = 0;

    //összesen megtett távolság
    private int distance = 0;

    /*
        KeyEvent.getCode() értékei az alábbi gomboknál

        VK.LEFT = 37
        VK.UP = 38
        VK.RIGHT = 39
        VK.DOWN = 40

        ? = 44
        : = 46

        VK.A = 65
        VK.W = 87
        VK.D = 68
        VK.S = 83

        SHIFT = 16
        CTRL = 17

    */

    //irányító gombok értékei (KeyEvent.getCode() alapján
    // minden robotnak külön irányítása van
    private int leftKey;
    private int upKey;
    private int rightKey;
    private int downKey;
    private int oilKey;
    private int glueKey;

    //igaz, ha éppen az adott gomb van lenyomva
    public boolean left;
    public boolean up;
    public boolean right;
    public boolean down;
    public boolean oil;
    public boolean glue;


    //robot talajhoz viszonyított állapota
    robotState state = robotState.ONGROUND;

    public Robot(int x, int y, int glueKey, int oilKey, int downKey, int rightKey, int upKey, int leftKey) {
        this.x = x;
        this.y = y;
        this.glueKey = glueKey;
        this.oilKey = oilKey;
        this.downKey = downKey;
        this.rightKey = rightKey;
        this.upKey = upKey;
        this.leftKey = leftKey;
    }

    //getter fv-ek

    public int getSpeed() {
        return speed;
    }

    public int getDeflection() {
        return deflection;
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

    public int getLeftKey() {
        return leftKey;
    }

    public int getUpKey() {
        return upKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public int getGlueKey() {
        return glueKey;
    }

    public int getOilKey() {
        return oilKey;
    }

    //azért kell, hogy a fix időnként váltáshoz (máshol állítjuk be) meg tudjuk adni egy külső fv-nek
    public robotState getState() {
        return state;
    }



    //sebességet és elhajlást módosító fv-ek  (setterek)


    public void getGlued() {
        if (state == robotState.ONGROUND) {
            speed /= 2;
        }
    }

    public void turnLeft(){
        if (state == robotState.ONGROUND) {
            deflection--;
        }
    }

    public void turnRight(){
        if (state == robotState.ONGROUND) {
            deflection++;
        }
    }

    public void speedUp(){

        if (state == robotState.ONGROUND) {
            speed++;
        }
    }

    public void slowDown(){
        if (state == robotState.ONGROUND) {
            speed--;
        }
    }

    public void putOil(){
        //TO DO
    }

    public void putGlue(){
        //TO DO
    }
}
