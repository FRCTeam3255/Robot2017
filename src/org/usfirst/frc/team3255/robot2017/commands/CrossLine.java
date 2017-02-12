package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLine extends CommandGroup {
	
	public double autoCrossD1() {
		return RobotPreferences.autoCrossD1();
	}
	
	public double autoCrossTurn() {
		return RobotPreferences.autoCrossTurn();
	}
	
	public double autoCrossD2() {
		return RobotPreferences.autoCrossD2();
	}

    public CrossLine() {
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
    	addSequential(new DriveDistance("CrossD1", autoCrossD1()));
    	addSequential(new DriveRotate("CrossTurn", autoCrossTurn()));
    	addSequential(new DriveDistance("CrossD2", autoCrossD2()));
    }
}
