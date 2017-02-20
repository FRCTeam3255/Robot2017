package org.usfirst.frc.team3255.robot2017.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DoDelay extends Command {

	private double expireTime;
	private double to;
	
    public DoDelay(double timeout) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        to = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTimer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	/*
	 * The startTimer and isTimerExpired methods of the Command class only work for times
	 * relative to the start of the initialization. Specifically, if you call
	 * startTimer(3 seconds) 2 seconds after your command initialized, isTimerExpired
	 * becomes true 1 second later.
	 * 
	 * Because we want the ability to set a timer that expires relative to when
	 * the timer was set, the methods setTimer and isTimerExpired create that
	 * functionality.
	 */
	protected void startTimer() {
		expireTime = timeSinceInitialized() + this.to;
	}
	
	protected boolean isFinished() {
		return (timeSinceInitialized() >= expireTime);
	}
}
