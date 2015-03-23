package phoebe.Model;

import java.awt.*;

/**
 * Created by Geri on 2015.02.19..
 */

// Ragacs csapda, melybe ha a robot belelép, megfelezi a sebességét
public class Glue extends Trap {

    public Glue(Point location, int round) {
        super(location, round);
    }



    // visitor
    @Override
    public void accept(Robot R2D2) {
        System.out.println("\u001B[33m"+"    ->[Glue].accept(Robot)"+"\u001B[0m");
        R2D2.visit(this);
    }

}
