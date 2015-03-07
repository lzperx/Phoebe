package phoebe.Model;

/**
 * Created by andri_000 on 2015.03.07..
 */
public interface VehicleProp {

    public void setSpeed(int speed);
    public void setState(Robot.robotState newState);


    public int getSpeed() ;
    public Robot.robotState getState();

}
