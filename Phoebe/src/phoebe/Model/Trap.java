package phoebe.Model;

import java.awt.*;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public abstract class Trap extends GameElements implements Visitor{

    public Trap(Point location) {
        super(location, 10);
    }


    public abstract int getTimeToLive();

    // dry függvény az olaj száradásához... ragacsnál nem csinál semmit
    public abstract void dry ();
}
