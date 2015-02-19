package phoebe;

/**
 * Created by Geri on 2015.02.19..
 */
public class Oil {
    private int x,y;
    private int round;
    private boolean life;

    public Oil(int y, int x, int round, boolean life) {
        this.y = y;
        this.x = x;
        this.round = round;
        this.life = life;
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
