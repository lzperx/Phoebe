package phoebe.Model;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public class Trap extends GameElements {

    protected String description = "Trap";

    public Trap(int y, int x, int hitbox) {
        this.y = y;
        this.x = x;
        this.hitbox = hitbox;
    }

    public String getDescription(){
        return description;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHitbox() {
        return hitbox;
    }

}
