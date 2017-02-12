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
	
    // Initialize your subsystem here
    public DrivetrainDistancePID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0, 0, 0);
    	this.setSetpoint(0.0);
    }

    public void enable() {
    	this.getPIDController().setPID(
    			RobotPreferences.driveDistanceP(),
    			RobotPreferences.driveDistanceI(),
    			RobotPreferences.driveDistanceD());
    	
    	setAbsoluteTolerance(RobotPreferences.distanceTolerance());
    	
    	double maxSpeed = RobotPreferences.maxMoveSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
    	outputValid = false;
    	
    	super.enable();
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
    	return output;
    }
    
    public boolean onRawTarget() {
    	return (Math.abs(Robot.drivetrain.getEncoderDistance() - getPIDController().getSetpoint()) < RobotPreferences.distanceTolerance());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
