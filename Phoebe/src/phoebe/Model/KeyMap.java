package phoebe.Model;

/**
 * Created by Brumi on 2015.03.01..
 */
public class KeyMap {

    private int leftKey;
    private int upKey;
    private int rightKey;
    private int downKey;
    private int oilKey;
    private int glueKey;

    /*
        KeyEvent.getCode() értékei az alábbi gomboknál

        VK.LEFT = 37
        VK.UP = 38
        VK.RIGHT = 39
        VK.DOWN = 40

        ? = 44
        : = 46

        VK.A = 65
        VK.W = 87
        VK.D = 68
        VK.S = 83

        SHIFT = 16
        CTRL = 17

    */

    //irányító gombok értékei (KeyEvent.getCode() alapján
    // minden robotnak külön irányítása van

    public boolean left;
    public boolean up;
    public boolean right;
    public boolean down;
    public boolean oil;
    public boolean glue;

    public KeyMap(int leftKey, int upKey, int rightKey, int downKey, int oilKey, int glueKey) {
        this.leftKey = leftKey;
        this.upKey = upKey;
        this.rightKey = rightKey;
        this.downKey = downKey;
        this.oilKey = oilKey;
        this.glueKey = glueKey;
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

    public int getOilKey() {
        return oilKey;
    }

    public int getGlueKey() {
        return glueKey;
    }

}
