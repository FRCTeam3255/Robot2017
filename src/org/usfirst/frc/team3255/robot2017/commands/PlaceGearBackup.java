package org.usfirst.frc.team3255.robot2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGearBackup extends CommandGroup {

    public PlaceGearBackup() {
    	addSequential(new GearDeployToPeg());
    	addSequential(new DoDelay(0.0));
    	addSequential(new DriveDistance("Backup", 12.0));
//    	addSequential(new GearRetract());
    }
}
