package phoebe;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public class Trap {
    private int x,y;
    private int round;
    private boolean life =true;

    public Trap(int y, int x, int round) {
        this.y = y;
        this.x = x;
        this.round = round;
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
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public boolean isLife() {
        return life;
    }

    public void cleanTrap() {
        life = false;
    }
}
