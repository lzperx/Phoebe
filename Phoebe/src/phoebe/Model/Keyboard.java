package phoebe.Model;

/**
 * Created by Muresan73 on 15. 02. 20..
 */
//aki tud szebb megoldást azt szívesen fogadom :) midenhol az írják nincs struct :(
    // minden robotnak kell legyen egy saját vezérlése
public  class Keyboard
{
    private int leftKey=39;
    private int upKey;
    private int rightKey;
    private int downKey;

    public boolean left;
    public boolean up;
    public boolean right;
    public boolean down;

    public Keyboard(int leftKey, int upKey, int rightKey, int downKey) {
        this.leftKey = leftKey;
        this.upKey = upKey;
        this.rightKey = rightKey;
        this.downKey = downKey;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public int getUpKey() {
        return upKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public int getDownKey() {
        return downKey;
    }
}