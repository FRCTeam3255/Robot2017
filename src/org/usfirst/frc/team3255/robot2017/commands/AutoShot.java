package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShot extends CommandGroup {
	
	public double autoShotD1() {
		return RobotPreferences.autoShotD1();
	}
	
	public double autoShotTurn() {
		return RobotPreferences.autoShotTurn();
	}

	public double autoShotD2() {
		return RobotPreferences.autoShotD2();
	}
	
	public double autoShotTime() {
		return RobotPreferences.autoShotTime();
	}
	
    public AutoShot() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveDistance("ShotD1", autoShotD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveRotate("ShotTurn", autoShotTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveDistance("ShotD2", autoShotD2()));
    	addSequential(new DoDelay(autoShotTime()));
    }
}
