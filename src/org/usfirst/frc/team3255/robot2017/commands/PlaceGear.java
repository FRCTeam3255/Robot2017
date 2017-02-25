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
				angle = -54;
			}
			else if(lane == 3) {
				angle = 54;
			}
		}
		else {
			if(lane == 1) {
				angle = 54;
			}
			else if(lane == 3) {
				angle = -54;
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
			distance = -77;
		}
		else {
			distance = 0;
		}

		return distance;
	}
	
	public double autoGearDelay() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearDelay();
		}
		
		if(AutoPreferences.doGear() == false) {
			return 0.0;
		}
		
		return 1.0;
	}
	
    public PlaceGear() {
    	addSequential(new DriveStraightDistance("GearD1", autoGearD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveAccurateRotate("GearTurn", autoGearTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveStraightDistance("GearD2", autoGearD2()));
    	addSequential(new DoDelay(autoGearDelay()));
    }
}
