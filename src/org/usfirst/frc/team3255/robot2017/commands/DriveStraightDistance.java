package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightDistance extends Command {

	double distance;
	String commandName;
	
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
    	Robot.drivetrainDistancePID.enable();
    	Robot.navYawPID.setSetpoint(0.0);
    	Robot.navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.drivetrainDistancePID.getOutput(), Robot.navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//taking the absolute value of the encoder distance and compares it to user input distance
        return (Robot.drivetrainDistancePID.onRawTarget() && Robot.navYawPID.onRawTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finished " + commandName);

    	Robot.drivetrainDistancePID.disable();
    	Robot.navYawPID.disable();
    	
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
