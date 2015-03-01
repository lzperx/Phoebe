package phoebe.Model;

import java.awt.*;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot extends GameElements {

    // pályaelem felett való áthaladáskor vizsgáljuk, ez alapján döntjük el, hogy csinálni kell e valamit. fix időközönként változik
    private static enum robotState {
        NORMAL,OILED
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


   public KeyMap keys;

    //igaz, ha éppen az adott gomb van lenyomva



    //robot talajhoz viszonyított állapota
    robotState state = robotState.NORMAL;

    public Robot(int x, int y,int hitbox,KeyMap keys, GameMapContainer gameMapContainer) {
        super(x,y,hitbox);

        this.keys = new KeyMap(
                keys.getLeftKey(),
                keys.getUpKey(),
                keys.getRightKey(),
                keys.getDownKey(),
                keys.getOilKey(),
                keys.getGlueKey());
        this.description = "Robot";
        backpack= new Backpack();
        this.gameMapContainer=gameMapContainer;
    }

    public void pollKey(){
        if(keys.left) turnLeft();
        if(keys.up) speedUp();
        if(keys.right) turnRight();
        if(keys.down) slowDown();
        if(keys.oil) putOil();
        if(keys.glue) putGlue();
    }

    public Point evaluate (){
        nextPosition = new Point(
                (int)(speed*Math.cos(angle)),
                (int)(speed*Math.sin(angle))
        );
        return nextPosition;
    }

    public void itsATrap(Trap i) {
        if(i.getDescription() == "Glue")  speed /= 2;
        if(i.getDescription() == "Oil") state = robotState.OILED;
        if(i.getDescription() == "Trap") {
         /*TODO játsza le hogy : " It's a Trap !!!" :D*/
            //soundPlayer.playSound("Itsatrap");
        }
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

    //azért kell, hogy a fix időnként váltáshoz (máshol állítjuk be) meg tudjuk adni egy külső fv-nek
    public robotState getState() {
        return state;
    }



    //sebességet és elhajlást módosító fv-ek  (setterek)

    public void Jump(){
        location = nextPosition;
        state = robotState.NORMAL;
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


    public void putOil(){
        if (!backpack.hasMoreOil()){
            System.out.println("Kifogytál az olajból!");
        }
        else{
            backpack.useOil();  // csökkenti az oil készletet

            //létrehozunk a pályán egy új foltot
            gameMapContainer.addTrap(new Oil(this.getLocation().x, this.getLocation().y, 10));
        }

    }

    public void putGlue(){
        if (!backpack.hasMoreGlue()){
            System.out.println("Kifogytál a ragacsból!");
        }
        else{
            backpack.useGlue(); // csökkenti a glue készletet

            //létrehozunk a pályán egy új foltot
            gameMapContainer.addTrap(new Glue(this.getLocation().x,this.getLocation().y, 10));
        }

    }
}
