package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

	double distance;
	String commandName;
	
	public DriveDistance(String name, double inches) {
        // We use this command for distances that did not have to be precise,
		// such as CrossLine in autonomous. Uses the same PID values as other
		// accurate commands, but the distance tolerance is multiplied by two.
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
    	
    	Robot.drivetrainDistancePID.setSetpoint(distance);
    	Robot.drivetrainDistancePID.setRawTolerance(RobotPreferences.distanceTolerance() * 2);
    	Robot.drivetrainDistancePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.drivetrainDistancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//taking the absolute value of the encoder distance and compares it to user input distance
        return Robot.drivetrainDistancePID.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finished " + commandName);

    	Robot.drivetrainDistancePID.disable();
    	
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
