package phoebe.Model;

import java.awt.*;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public abstract class Trap extends GameElements implements Visitor{

    public Trap(Point location, int hitbox) {
        super(location,hitbox);
    }


    public abstract int getTimeToLive();

    // dry függvény az olaj száradásához... ragacsnál nem csinál semmit
    public abstract void dry ();
}
