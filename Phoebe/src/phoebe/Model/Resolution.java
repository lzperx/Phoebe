package phoebe.Model;

/* by Brumi */

/* egyszerű csomagolóosztály a felbontás tárolására, így az egyetlen paraméterként a konstruktornak átadható */

import java.awt.*;

public class Resolution {


    private final Dimension dimension;



    Resolution(Dimension dim){
        dimension = new Dimension((int)dim.getWidth(),(int)dim.getHeight());
    }

    Resolution(int width, int height){
        dimension = new Dimension(width, height);
    }

    public int getWidth(){
        return (int)dimension.getWidth();
    }

    public int getHeight(){
        return (int)dimension.getHeight();
    }

}