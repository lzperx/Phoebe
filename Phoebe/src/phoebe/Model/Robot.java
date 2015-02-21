package phoebe.Model;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot {

    // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    private static enum robotState {
        JUMP,ONGROUND
    }


    //helyzet
    private int x;
    private int y;

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

        VK.A = 65
        VK.W = 87
        VK.D = 68
        VK.S = 83

    */

    //irányító gombok értékei (KeyEvent.getCode() alapján
    // minden robotnak külön irányítása van
    private int leftKey;
    private int upKey;
    private int rightKey;
    private int downKey;

    //igaz, ha éppen az adott gomb van lenyomva
    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;


    //robot talajhoz viszonyított állapota
    robotState state = robotState.ONGROUND;

    public Robot(int x, int y, int leftKey, int upKey, int rightKey, int downKey) {
        this.x = x;
        this.y = y;
        this.leftKey = leftKey;
        this.upKey = upKey;
        this.rightKey = rightKey;
        this.downKey = downKey;
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

    //azért kell, hogy a fix időnként váltáshoz (máshol állítjuk be) meg tudjuk adni egy külső fv-nek
    public robotState getState() {
        return state;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isDown() {
        return down;
    }


    //setter fv-ek


    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setDown(boolean down) {
        this.down = down;
    }


    //sebességet és elhajlást módosító fv-ek


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
}
