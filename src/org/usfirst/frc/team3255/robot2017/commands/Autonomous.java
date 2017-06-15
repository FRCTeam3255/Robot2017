package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	if (AutoPreferences.doTwoGear()){
        	addSequential(new PlaceTwoGear());
    	}
    	else{
    	addSequential(new DriveShiftUp());
    	addSequential(new PlaceGear());
    	addSequential(new AutoShot());
    	addSequential(new CrossLine());
    	}
    }
}
