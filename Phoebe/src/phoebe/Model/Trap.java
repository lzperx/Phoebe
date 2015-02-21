package phoebe.Model;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public class Trap extends GameElements {

    private boolean life =true;

    public Trap(int y, int x, int hitbox) {
        this.y = y;
        this.x = x;
        this.hitbox = hitbox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRound() {
        return hitbox;
    }

    public void setRound(int round) {
        this.hitbox = round;
    }

    public boolean isLife() {
        return life;
    }

    public void cleanTrap() {
        life = false;
    }
}
