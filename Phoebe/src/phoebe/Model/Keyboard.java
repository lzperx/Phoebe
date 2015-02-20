package phoebe.Model;


/**
 * Created by Muresan73 on 15. 02. 20..
 */
//aki tud szebb megoldást azt szívesen fogadom :) midenhol az írják nincs struct :(
    // minden robotnak kell legyen egy saját vezérlése

public  class Keyboard
{

    private int leftKey;
    private int upKey;
    private int rightKey;
    private int downKey;


    public boolean left;
    public boolean up;
    public boolean right;
    public boolean down;


    public Keyboard(int leftKey, int upKey, int rightKey, int downKey) {

        //ahol majd létrehozom a Keyboard pédányt, ott így kell megadnom majd
        //pl a nyilakra : new Keyborad(e.VK_LEFT,e.VK_UP,e.VK_RIGHT,e.VK_DOWN)
        //pl AWSD-re    : new Keyborad(e.VK_A,e.VK_W,e.VK_D,e.VK_S)

        this.leftKey= leftKey;
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