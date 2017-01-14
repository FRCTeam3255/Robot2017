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
    	double rawSpeed = Robot.oi.shooterStick.getRawAxis(RobotMap.SHOOTER_SPEED_AXIS);
    	double speed = (-rawSpeed + 1) / 2;
    	
    	Robot.shooter.setSpeed(speed);
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
