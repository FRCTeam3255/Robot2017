package org.usfirst.frc.team3255.robot2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearandShoot extends CommandGroup {

    public AutoGearandShoot() 
    {
    	addSequential(new PlaceGear());
    	addSequential(new AutoShot());
    	
   }
}
