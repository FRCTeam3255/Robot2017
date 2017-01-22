package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetShooterSpeed extends Command {

    public SetShooterSpeed() {
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Checking to see if button 10 on shooterStick is pressed
    	boolean isPressed = Robot.oi.shooterStick.getRawButton(10);
    	
    	double rawSpeed = Robot.oi.shooterStick.getRawAxis(RobotMap.SHOOTER_SPEED_AXIS);
    	// converting axis to motor output
    	double normalizedSpeed = (-rawSpeed + 1) / 2;
    	
    	//TODO 
    	double maxHighSpeed = 1.0;
    	
    	double maxLowSpeed = 0.6;
    	
    	if (isPressed) {
    		Robot.shooter.setShooterSpeed(maxLowSpeed * normalizedSpeed);
    	}
    	else{
    		Robot.shooter.setShooterSpeed(maxHighSpeed * normalizedSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
