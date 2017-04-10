package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class NavigationYawDriveStraightPID extends PIDSubsystem {

	double output = 0.0;
	boolean outputValid = false;
	int targetCounter = 0;
	double tolerance = 0.0;
	
    // Initialize your subsystem here
    public NavigationYawDriveStraightPID() {
    	super(0,0,0);
    	this.setSetpoint(0.0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	setRawTolerance(RobotPreferences.yawDriveTolerance());
    }

    public void enable() {
      	this.getPIDController().setPID(
    			RobotPreferences.navYawDriveP(),
    			RobotPreferences.navYawDriveI(),
    			RobotPreferences.navYawDriveD());
      	
      	setAbsoluteTolerance(RobotPreferences.yawDriveTolerance());
      	
      	double maxSpeed = RobotPreferences.maxYawDriveSpeed();
      	this.setOutputRange(-maxSpeed, maxSpeed);
      	
      	outputValid = false;
      	
      	super.enable();
    }
    
    private double getCalculatedYaw() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	double yaw = Robot.navigation.getYaw();

        return yaw;
    }
    
    protected double returnPIDInput() {
    	return getCalculatedYaw();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	
    	double minYaw = RobotPreferences.minYawDriveSpeed();
    	  
    	if(Math.abs(output) < minYaw) {
    		if(output < 0) {
    			output = -minYaw;
    		}
    		else {
    			output = minYaw;
    		}
    	}
    	
    	return output;
    }
    
	public void setRawTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
    
    public boolean onRawTarget() {
    	double setPoint = getPIDController().getSetpoint();
    	double calculatedYaw = getCalculatedYaw();
    	double error = setPoint - calculatedYaw;
    	
    	if (Math.abs(error) < tolerance) {
    		targetCounter = targetCounter + 1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	
    	return (targetCounter >= RobotPreferences.targetCount());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
