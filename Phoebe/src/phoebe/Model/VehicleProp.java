package phoebe.Model;

/**
 * Created by andri_000 on 2015.03.07..
 */
public interface VehicleProp {

    public void setState(Robot.robotState newState);
    public void setSpeed (int newSpeed);
    public int getSpeed();
    public Robot.robotState getState();

}
