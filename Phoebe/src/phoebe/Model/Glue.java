package phoebe.Model;

/**
 * Created by Geri on 2015.02.19..
 */
public class Glue extends Trap {

    public Glue(int x, int y, int round) {
        super(x, y, round);
        description = "Glue";
    }

    @Override
    public void vehicleModifier(vehicleProp currentVehicle) {
        currentVehicle.setSpeed(currentVehicle.getSpeed()/2);
    }
}
