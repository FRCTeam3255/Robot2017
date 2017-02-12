package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class NavigationYawPID extends PIDSubsystem {

	double output = 0.0;
	boolean outputValid = false;
	
    // Initialize your subsystem here
    public NavigationYawPID() {
    	super(0,0,0);
    	this.setSetpoint(0.0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void enable() {
      	this.getPIDController().setPID(
    			RobotPreferences.navYawP(),
    			RobotPreferences.navYawI(),
    			RobotPreferences.navYawD());
      	
      	setAbsoluteTolerance(RobotPreferences.yawTolerance());
      	
      	double maxSpeed = RobotPreferences.maxYawSpeed();
      	this.setOutputRange(-maxSpeed, maxSpeed);
      	
      	outputValid = false;
      	
      	super.enable();
    }
    
    private double getCalculatedYaw() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	double yaw = Robot.navigation.getYaw();
    	if(yaw < 0) {
    		yaw = yaw + 360;
    	}
//		System.out.println("Yaw < 0 adding 360, newYaw "+ yaw);

    	
    	// compute what the current error is based on this yaw value
    	double error = this.getSetpoint() - yaw; 	
   
    	if(error > 180) {;
    		yaw = yaw + 360;
    	}
    	else if(error < -180) {
    		yaw = yaw - 360;
    	}
        return yaw;
    }
    
    protected double returnPIDInput() {
    	return getCalculatedYaw();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = -output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	return output;
    }
    
    public boolean onRawTarget() {
//    	System.out.println(getCalculatedYaw());
    	return (Math.abs(getPIDController().getSetpoint() - getCalculatedYaw()) < RobotPreferences.yawTolerance());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
