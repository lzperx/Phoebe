package phoebe.Model;

import java.awt.*;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot extends GameElements {

    // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    private static enum robotState {
        JUMP,ONGROUND,OILED
    }

    // hátizsák a foltoknak
    private Backpack backpack;

    //átadjuk az adott pályát is, hogy tudjon lerakni trappeket.
    private GameMapContainer gameMapContainer;

    //A robot ahova ugrani fog legközelebb
    private Point nextPosition;

    // a robot sebessége
    private int speed = 0;

    //szögelfordulás
    private double angle = 0;

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

    public Robot(int x, int y,int hitbox, int glueKey, int oilKey, int downKey, int rightKey, int upKey, int leftKey, GameMapContainer gameMapContainer) {
        super(x,y,hitbox);

        this.glueKey = glueKey;
        this.oilKey = oilKey;
        this.downKey = downKey;
        this.rightKey = rightKey;
        this.upKey = upKey;
        this.leftKey = leftKey;
        this.description = "Robot";
        backpack= new Backpack();
        this.gameMapContainer=gameMapContainer;
    }

    public void pollKey(){
        if(left) turnLeft();
        if(up) speedUp();
        if(right) turnRight();
        if(down) slowDown();
        if(oil) putOil();
        if(glue) putGlue();
    }

    public Point evaluate (){


        // Ez nagyon undorító de hatékony
        nextPosition = new Point(
                (int)(speed*Math.cos(angle)),
                (int)(speed*Math.sin(angle))
        );

        //megvan az új hely, így az szöget visszaállíthatjuk 0-ba
        angle=0;

        return nextPosition;
    }

    public void itsATrap(Trap i) {
        if(i.getDescription() == "Glue")  speed /= 2;
        if(i.getDescription() == "Oil") state = robotState.OILED;
        if(i.getDescription() == "Trap") /*TODO játsza le hogy : " It's a Trap !!!" :D*/;
    }

    //getter fv-ek

    public int getSpeed() {
        return speed;
    }

    public double getAngle() {
        return angle;
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

    public void Jump(){
        location = nextPosition;
    }


    public void turnLeft(){
//        if (state == robotState.ONGROUND)
        {
          // szögelfordulás balra 10 fokkal (minden nextPosition beállításkor az angle=0 lesz)
            angle=-10;
        }
    }

    public void turnRight(){
//        if (state == robotState.ONGROUND)
        {
            // szögelfordulás jobbra 10 fokkal (minden nextPosition beállításkor az angle=0 lesz)
            angle=+10;
        }
    }

    public void speedUp(){

//        if (state == robotState.ONGROUND)
        {
            speed++;
        }
    }

    public void slowDown(){
//        if (state == robotState.ONGROUND)
        {
            speed--;
        }
    }


    public void putOil(){
        if (backpack.getAmmountofOil()==0){
            System.out.println("Kifogytál az olajból!");
        }
        else{
            backpack.useOil();  // csökkenti az oil készletet

            //létrehozunk a pályán egy új foltot
            gameMapContainer.addTrap(new Oil(this.getLocation().x, this.getLocation().y, 10));
        }

    }

    public void putGlue(){
        if (backpack.getAmmountofOil()==0){
            System.out.println("Kifogytál az zsírból!");
        }
        else{
            backpack.useGlue(); // csökkenti a glue készletet

            //létrehozunk a pályán egy új foltot
            gameMapContainer.addTrap(new Glue(this.getLocation().x,this.getLocation().y, 10));
        }

    }
}
