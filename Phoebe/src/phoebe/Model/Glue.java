package phoebe.Model;

import java.awt.*;

/**
 * Created by Geri on 2015.02.19..
 */
public class Glue extends Trap {

    public Glue(Point location, int round) {
        super(location, round);
    }

    @Override
    public void vehicleModifier(VehicleProp currentVehicle) {
        currentVehicle.setSpeed(currentVehicle.getSpeed()/2);
    }
}
