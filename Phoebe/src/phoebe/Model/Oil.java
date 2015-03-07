package phoebe.Model;

/**
 * Created by Geri on 2015.02.19..
 */
public class Oil extends Trap {

    public Oil(int x, int y, int hitbox) {
        super(x, y, hitbox);
    }

    @Override
    public void vehicleModifier(VehicleProp currentVehicle) {
        currentVehicle.setState(Robot.robotState.OILED);
    }


}
