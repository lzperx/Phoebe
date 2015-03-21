package phoebe.Model;

/* by Brumi */

/* egyszerű csomagolóosztály a felbontás tárolására,
   így az egyetlen paraméterként a konstruktornak átadható.
   Dimensiont használ intekké alakítva.
*/

import java.awt.*;

public class Resolution {

    private final Dimension dimension;

    //konstruktor Dimension -nel
    Resolution(Dimension dim){
        dimension = new Dimension((int)dim.getWidth(),(int)dim.getHeight());
    }
    //konstruktor intekkel
    Resolution(int width, int height){
        dimension = new Dimension(width, height);
    }

    // getterek
    public int getWidth(){
        return (int)dimension.getWidth();
    }
    public int getHeight(){
        return (int)dimension.getHeight();
    }

}