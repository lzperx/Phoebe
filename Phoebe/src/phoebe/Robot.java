package phoebe;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public class Robot {

    private int speed;
    private int x;
    private int y;
    private int distance = 0;
    State state = State.JUMP;

    public Robot(int speed, int x, int y) {
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public void getGlued(){
        speed /=2;
    }

    public void getOiled(){
        state = State.SLIPPED;
    }

}
