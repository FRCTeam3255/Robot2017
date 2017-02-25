package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGear extends CommandGroup {

	public double autoGearD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearD1();
		}
		
		if((AutoPreferences.doGear() == false) || (AutoPreferences.getLane() == 0)) {
			return 0.0;
		}

		int lane = AutoPreferences.getLane();
		double distance = 0.0;
		
		if((lane == 1) || lane == 3) {
			distance = -57.2;
		}
		else {
			distance = -80;
		}

		return distance;
	}
	
	public double autoGearTurn() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearTurn();
		}
		
		if((AutoPreferences.doGear() == false) || (AutoPreferences.getLane() == 0)) {
			return 0.0;
		}
		
		double angle = 0;

		int lane = AutoPreferences.getLane();

		if(AutoPreferences.isRedAlliance()) {
			if(lane == 1) {
				angle = -55;
			}
			else if(lane == 3) {
				angle = 55;
			}
		}
		else {
			if(lane == 1) {
				angle = 55;
			}
			else if(lane == 3) {
				angle = -55;
			}			
		}
		
		return angle;
	}
	
	public double autoGearD2() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearD2();
		}
		
		if((AutoPreferences.doGear() == false) || (AutoPreferences.getLane() == 0)) {
			return 0.0;
		}

		int lane = AutoPreferences.getLane();
		double distance = 0.0;
		
		if((lane == 1) || lane == 3) {
			distance = -75;
		}
		else {
			distance = 0;
		}

		return distance;
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
    	addSequential(new DriveStraightDistance("GearD1", autoGearD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveRotate("GearTurn", autoGearTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveStraightDistance("GearD2", autoGearD2()));
    	addSequential(new DoDelay(autoGearDelay()));
    }
}
