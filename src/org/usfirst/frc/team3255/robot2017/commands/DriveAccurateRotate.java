package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAccurateRotate extends Command {

	double yaw;
	String commandName;
	private double expireTime;
	
    public DriveAccurateRotate(String name, double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.navYawPID);
    	
    	yaw = degrees;
    	commandName = name;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.shiftUp();
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + yaw);

    	Robot.navYawPID.disable();

    	Robot.navigation.resetYaw();
    	Robot.navYawPID.setSetpoint(yaw);
    	Robot.navYawPID.setRawTolerance(RobotPreferences.yawTolerance());
    	
    	Robot.navYawPID.enable();
    	
    	expireTime = timeSinceInitialized() + 2.5;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0.0, Robot.navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean onTarget = Robot.navYawPID.onRawTarget();
    	
    	double timeNow = timeSinceInitialized();
    	if(AutoPreferences.isDebug()) {
			System.err.println("expire=" + expireTime + " timeNow=" + timeNow);
		}
   	
    	if(timeNow >= expireTime) {
//    		if(AutoPreferences.isDebug()) {
    			System.err.println("TimedOut");
//    		}
    		return true;
    	}
    	
    	if(onTarget) {
        	Robot.drivetrain.arcadeDrive(0.0, 0.0);    		
    	}
        return onTarget;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);

    	Robot.telemetry.setAutonomousStatus("Finished " + commandName);
    	
    	Robot.navYawPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
