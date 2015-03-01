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
