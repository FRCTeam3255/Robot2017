package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotate extends Command {

	double yaw;
	String commandName;
	
    public DriveRotate(String name, double degrees) {
    	// We use this command for rotations that do not have to be precise,
    	// such as CrossLine in autonomous. Uses the same PID values as other
    	// accurate commands, but the yaw tolerance is multiplied by five.
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
    	Robot.navYawPID.setRawTolerance(RobotPreferences.yawTolerance() * 5);
    	
    	Robot.navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0.0, Robot.navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean onTarget = Robot.navYawPID.onRawTarget();
    	
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
