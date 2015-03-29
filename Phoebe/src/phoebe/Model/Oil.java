package phoebe.Model;

import java.awt.*;

/**
 * Created by Geri on 2015.02.19..
 */

// Olaj csapda, melybe a robot ha belelép, nem tud irányt változtatni.
public class Oil extends Trap {

    // az olaj 4 kör/ugrás után felszárad, ugrásonként csökkentjük.
    private int timeToLive = 4;

    public Oil(Point location) {
        super(location);
    }



    @Override
    public int getTimeToLive() {
        return timeToLive;
    }

    @Override
    public void dry() {
    timeToLive--;
    }


    // visitor
    @Override
    public void accept(PlayerRobot R2D2) {
        System.out.println(""+"    ->[Oil].accept(Robot)"+"" );
        R2D2.visit(this);

    }

}
