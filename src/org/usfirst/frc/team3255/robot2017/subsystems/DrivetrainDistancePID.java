package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DrivetrainDistancePID extends PIDSubsystem {

	double output = 0.0;
	boolean outputValid = false;
	int targetCounter = 0;
	double tolerance = 0.0;
	
    // Initialize your subsystem here
    public DrivetrainDistancePID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0, 0, 0);
    	this.setSetpoint(0.0);
    	
    	setRawTolerance(RobotPreferences.distanceTolerance() / 12);
    }

    public void enable(double maxSpeed) {
    	this.getPIDController().setPID(
    			RobotPreferences.driveDistanceP(),
    			RobotPreferences.driveDistanceI(),
    			RobotPreferences.driveDistanceD());
    	
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
    	outputValid = false;
    	
    	super.enable();
    }
    
    public void enable() {
    	enable(RobotPreferences.maxMoveSpeed());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.drivetrain.getEncoderDistance();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if((this.getPIDController().isEnabled() == false) || (outputValid == false)) {
    		return 0.0;
    	}
   
    	double minSpeed = RobotPreferences.minMoveSpeed();
  
    	if(Math.abs(output) < minSpeed) {
    		if(output < 0) {
    			output = -minSpeed;
    		}
    		else {
    			output = minSpeed;
    		}
    	}
    	
    	return output;
    }
    
	public void setRawTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
    
    public boolean onRawTarget() {
    	
    	if (Math.abs(getPIDController().getSetpoint() - Robot.drivetrain.getEncoderDistance()) < tolerance) {
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
