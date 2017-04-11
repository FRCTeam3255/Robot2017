package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightDistance extends Command {

	double distance;
	String commandName;
	private double expireTime;
	
	public DriveStraightDistance(String name, double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.drivetrainDistancePID);
    	
    	distance = inches / 12.0;
    	commandName = name;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + distance);
    	Robot.drivetrain.shiftUp();
    	Robot.drivetrain.resetEncoderCount();
    	Robot.navigation.resetYaw();
    	
    	Robot.drivetrainDistancePID.setSetpoint(distance);
    	Robot.drivetrainDistancePID.setRawTolerance(RobotPreferences.distanceTolerance());
    	Robot.drivetrainDistancePID.enable();
    	Robot.navYawPIDDrive.setSetpoint(0.0);
    	Robot.navYawPIDDrive.enable();
    	
    	expireTime = timeSinceInitialized() + 5.0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.drivetrainDistancePID.getOutput(), Robot.navYawPIDDrive.getOutput());
    	
    	if(AutoPreferences.isDebug()) {
	    	if (Robot.drivetrainDistancePID.onRawTarget()) {
	    		System.err.println("Distance Met");
	    	}
	    	
	    	if (Robot.navYawPIDDrive.onRawTarget()) {
	    		System.err.println("Rotation Met");
	    	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double timeNow = timeSinceInitialized();
		if(AutoPreferences.isDebug()) {
			System.err.println("expire=" + expireTime + " timeNow=" + timeNow);
		}
		
    	if(timeNow >= expireTime) {
    		if(AutoPreferences.isDebug()) {
    			System.err.println("TimedOut");
    		}
    		return true;
    	}
    	//taking the absolute value of the encoder distance and compares it to user input distance
        return (Robot.drivetrainDistancePID.onRawTarget() && Robot.navYawPIDDrive.onRawTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finished " + commandName);

    	Robot.drivetrainDistancePID.disable();
    	Robot.navYawPIDDrive.disable();
    	
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
