package phoebe.Model;

import java.awt.*;

/**
 * Created by Muresan73 on 15. 02. 21..
 */
public abstract class GameElements {
    protected Point location;
    protected int hitbox;

    public GameElements(int x, int y, int hitbox) {
        location = new Point(x,y);
        this.hitbox = hitbox;
    }


    public Point getLocation() {
        return location;
    }

    public int getHitbox() {
        return hitbox;
    }

}
