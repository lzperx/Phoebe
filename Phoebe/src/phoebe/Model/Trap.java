package phoebe.Model;

/**
 * Created by Muresan73 on 15. 02. 19..
 */
public abstract class Trap extends GameElements {

    public Trap(int x, int y, int hitbox) {
        super(x,y,hitbox);
    }


    public abstract void vehicleModifier(vehicleProp currentVehicle);


}
