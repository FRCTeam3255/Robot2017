package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGear extends CommandGroup {

	public double autoGearD1() {
		return RobotPreferences.autoGearD1();
	}
	
	public double autoGearTurn() {
		return RobotPreferences.autoGearTurn();
	}
	
	public double autoGearD2() {
		return RobotPreferences.autoGearD2();
	}
	
	public double autoGearDelay() {
		return RobotPreferences.autoGearDelay();
	}
	
    public PlaceGear() {
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
    	addSequential(new DriveDistance("GearD1", autoGearD1()));
    	addSequential(new DriveRotate("GearTurn", autoGearTurn()));
    	addSequential(new DriveDistance("GearD2", autoGearD2()));
    	addSequential(new DoDelay(autoGearDelay()));
    }
}
