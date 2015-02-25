package phoebe.Model;



/* egyszerű csomagolóosztály a felbontás tárolására, így az egyetlen paraméterként a konstruktornak átadható */

public class Resolution {

    private final int width;
    private final int height;

    Resolution(int wdth, int hght){
        width = wdth;
        height = hght;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}