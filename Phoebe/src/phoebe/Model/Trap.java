package phoebe.Model;

import java.awt.*;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public abstract class Trap extends GameElements {

    public Trap(Point location, int hitbox) {
        super(location,hitbox);
    }


    public abstract void vehicleModifier(VehicleProp currentVehicle);


}
