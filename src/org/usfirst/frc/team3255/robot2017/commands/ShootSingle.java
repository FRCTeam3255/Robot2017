package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootSingle extends CommandGroup {

    public ShootSingle() {
        // start the loader
    	addSequential(new LoaderStart());
    	
    	// wait until the ball closes the limit switch in the shooter
    	addSequential(new ShooterCheckBallShot());

    	// run the loader a little longer to make sure one ball is shot
    	double loaderDelay = 0.2;
    	addSequential(new DoDelay(loaderDelay));
    	
    	// stop the loader
    	addSequential(new LoaderStop());
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.loaderDisable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
