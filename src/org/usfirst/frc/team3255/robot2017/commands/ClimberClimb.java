package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberClimb extends Command {
	
    public ClimberClimb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climber.forward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	// stop if climber is not enabled, or the climber switch is closed meaning it's at the top of the rope
    	if ((Robot.climber.isClimberEnabled() == false)) {
    		return true;
    	}
    	
    	if(Robot.climber.isTouchpadSwitchClosed() == false) {
    		Robot.climber.resetEncoderCount();
    	}
    	
    	return (Robot.climber.getEncoderDistance() >= RobotPreferences.climbDistance());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
