package phoebe.Model;

import java.awt.*;

/*
 * Created by Muresan73 on 15. 02. 19..
 */
public class PlayerRobot extends CleanerRobot {


    //=============================================================
    //-----------Ideiglenes csak szkeletonos methódusok------------
    //=============================================================


    public void setAcceleration(int acceleration){
        if(this.state==robotState.NORMAL){
            this.speed += acceleration;
        }

        //különben meg semmi, mert olajon vagyunk és csúszunk
    }

    public void setRightTurnDegree(double turnDegree){
        angle -= Math.toRadians(turnDegree);
    }

    public void setLeftTurnDegree(double turnDegree){
        angle += Math.toRadians(turnDegree);
    }
    //=============================================================

    /* Enumeráció a robot aktuális állapotara.
       Ez határozza meg, hogy van-e lehetőség iránymódosításra
       az aktuális földetéréskor.
       Az olajt paraméterül váró visit metódus ezt állítja be.
    */
    public static enum robotState {
        NORMAL,OILED
    }

    //összesen megtett távolság
    private double distance = 0;

    //Összes oil
    public int ammountofOil;
    //Összes glue
    public int ammountofGlue;

    // a robot billentyűzetkiosztása
    public KeyMap keys;

    //robot talajhoz viszonyított állapota
    public robotState state = robotState.NORMAL;

    // konstruktor
    public PlayerRobot(Point location, int hitbox, KeyMap keys) {
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
    public Point getNextPosition() {
        return nextPosition;
    }

    public double getAngle() {
        return angle;
    }

    //sebességet és elhajlást módosító fv-ek  (setterek)

    // a CleanerRobot jump fv ében nincs distance állítás
    @Override
    public void jump(){
        System.out.println(""+"    ->[Robot].jump()"+"" );
        distance += nextPosition.distance(location);
        location = nextPosition;
    }

    public void turnLeft(){
        System.out.println(""+"    ->[Robot].turnLeft()"+"" );
          // szögelfordulás balra 10 fokkal (minden nextPosition beállításkor az angle=0 lesz)
            angle =- 0.1;//TODO normális érték

    }

    public void turnRight(){
        System.out.println(""+"    ->[Robot].turnRight()"+"" );
            // szögelfordulás jobbra 10 fokkal (minden nextPosition beállításkor az angle=0 lesz)
            angle =+ 0.1;//TODO normális érték

    }

    public void speedUp(){
        System.out.println(""+"    ->[Robot].speedUp()"+"" );
        if (state == robotState.NORMAL)
            speed += 15;
    }

    public void slowDown(){
        System.out.println(""+"    ->[Robot].slowDown()"+"" );
        if (state == robotState.NORMAL)
            speed += 15;
    }

    public double getDistance(){
        return distance;
    }


    public robotState getState() {
        return state;
    }

    public int getSpeed(){
        return speed;
    }


    /*****************************************************************************************************************/
    /*****                                         VISITOR PATTERN                                               *****/
    /*****************************************************************************************************************/


    /* A robotok csapdával való érintkezését oldja meg,
        minden csapda saját magát adja át a visit metódusnak,
        így a megfelelő kód fut le.
     */
    void visit(Oil oil){
        System.out.println(""+"    ->[Robot].visit(Oil)"+"" );
        state = robotState.OILED;
        System.out.print("Run on OIL\n");

    }

    void visit(Glue glue){
        System.out.println(""+"    ->[Robot].visit(Glue)"+"" );
       speed /= 2;
        System.out.print("Run on GLUE\n");

    }

}
