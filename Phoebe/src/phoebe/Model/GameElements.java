package phoebe.Model;

/**
 * Created by Muresan73 on 15. 02. 21..
 */
public class GameElements {
    protected int x,y;
    protected int hitbox;
    protected String description ;

    public GameElements(int x, int y, int hitbox) {
        this.x = x;
        this.y = y;
        this.hitbox = hitbox;
        this.description = "GameElement";
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
