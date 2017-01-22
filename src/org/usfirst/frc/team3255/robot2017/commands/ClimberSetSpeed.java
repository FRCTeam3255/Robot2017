package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberSetSpeed extends Command {

	int count = 0;
	
    public ClimberSetSpeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climber.setClimberSpeed(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Keeps motor from running when climber is in reverse configuration
    	// Stops motors from running after switch is closed	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       // TODO Decide count amount.
    	return (Robot.climber.isClimberSwitchClosed());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.setClimberSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
