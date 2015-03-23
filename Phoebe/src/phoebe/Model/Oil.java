package phoebe.Model;

import java.awt.*;

/**
 * Created by Geri on 2015.02.19..
 */

// Olaj csapda, melybe a robot ha belelép, nem tud irányt változtatni.
public class Oil extends Trap {

    public Oil(Point location, int hitbox) {
        super(location, hitbox);
    }

    // visitor
    @Override
    public void accept(Robot R2D2) {
        System.out.println("\u001B[33m"+"    ->[Oil].accept(Robot)"+"\u001B[0m" );
        R2D2.visit(this);
    }

}
