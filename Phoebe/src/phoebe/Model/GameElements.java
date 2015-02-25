package phoebe.Model;

import java.awt.*;

/**
 * Created by Muresan73 on 15. 02. 21..
 */
public class GameElements {
    protected Point location;
    protected int hitbox;
    protected String description ;

    public GameElements(int x, int y, int hitbox) {
        location = new Point(x,y);
        this.hitbox = hitbox;
        this.description = "GameElement";
    }

    public String getDescription(){
        return description;
    }

    public Point getLocation() {
        return location;
    }

    public int getHitbox() {
        return hitbox;
    }

}
