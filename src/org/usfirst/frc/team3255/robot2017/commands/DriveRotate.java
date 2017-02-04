package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotate extends Command {

	double yaw;
	
    public DriveRotate(double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.navYawPID);
    	
    	yaw = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.shiftDown();
    	Robot.navigation.resetYaw();
    	
    	Robot.navYawPID.setSetpoint(yaw);
    	Robot.navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0.0, Robot.navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.navYawPID.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.navYawPID.disable();
    	
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
