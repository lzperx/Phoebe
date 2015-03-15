package phoebe.Model;

import java.awt.*;

/**
 * Created by Geri on 2015.02.19..
 */
public class Oil extends Trap {

    public Oil(Point location, int hitbox) {
        super(location, hitbox);
    }


    @Override
    public void accept(Robot R2D2) {
        R2D2.visit(this);
    }

}
