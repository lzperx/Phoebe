package phoebe.Model;

import java.awt.*;

/**
 * Created by Muresan73 on 15. 02. 21..
 */
public abstract class GameElements {
    protected Point location;
    protected int hitbox;

    public GameElements(Point location, int hitbox) {
        this.location = location;
        this.hitbox = hitbox;
    }


    public Point getLocation() {
        return location;
    }

    public int getHitbox() {
        return hitbox;
    }

}
