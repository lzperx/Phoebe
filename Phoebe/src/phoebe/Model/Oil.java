package phoebe.Model;

/**
 * Created by Geri on 2015.02.19..
 */
public class Oil extends Trap {

    public Oil(int x, int y, int hitbox) {
        super(x, y, hitbox);
        description = "Oil";
    }

    @Override
    public void vehicleModifier(vehicleProp currentVehicle) {
        currentVehicle.setState(Robot.robotState.OILED);
    }


}
