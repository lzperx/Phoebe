package phoebe;

/**
 * Created by Geri on 2015.02.19..
 */
public class Oil {
    private int x,y;
    private int round;
    private boolean life =true;

    public Oil(int y, int x, int round) {
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

    public void setLife(boolean life) {
        this.life = life;
    }
}
